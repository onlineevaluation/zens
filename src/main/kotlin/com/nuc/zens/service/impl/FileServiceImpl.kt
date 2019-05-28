package com.nuc.zens.service.impl

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.Student
import com.nuc.zens.po.Title
import com.nuc.zens.po.User
import com.nuc.zens.po.UserAndRole
import com.nuc.zens.po.entity.Course
import com.nuc.zens.po.relation.CourseAndCollege
import com.nuc.zens.po.relation.CourseTarAndKnowledge
import com.nuc.zens.repository.*
import com.nuc.zens.repository.point.CollegeTargetRepository
import com.nuc.zens.repository.point.CourseRepository
import com.nuc.zens.repository.point.CourseTargetRepository
import com.nuc.zens.repository.point.KnowledgeRepository
import com.nuc.zens.repository.relation.CourseAndCollegeRepository
import com.nuc.zens.repository.relation.CourseTarAndKnowledgeRepository
import com.nuc.zens.service.FileService
import org.apache.poi.ss.usermodel.*
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.xmlbeans.SchemaType
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTCol
import org.openxmlformats.schemas.spreadsheetml.x2006.main.impl.CTColsImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream
import java.sql.Date

/**
 * @author 杨晓辉 4/27/2019 7:45 PM
 */
@Service
class FileServiceImpl : FileService {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var classRepository: ClassRepository

    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository

    @Autowired
    private lateinit var courseRepository: CourseRepository

    @Autowired
    private lateinit var collegeTargetRepository: CollegeTargetRepository

    @Autowired
    private lateinit var courseTargetRepository: CourseTargetRepository

    @Autowired
    private lateinit var chapterRepository: ChapterRepository

    @Autowired
    private lateinit var userAndRoleRepository: UserAndRoleRepository

    @Autowired
    private lateinit var courseAndCollegeRepository: CourseAndCollegeRepository

    @Autowired
    private lateinit var courseTarAndKnowledgeRepository: CourseTarAndKnowledgeRepository

    private lateinit var workbook: Workbook

    /**
     * 上传学生信息
     * @param file MultipartFile 上传学生信息
     * @param type String
     */
    @Transactional
    override fun uploadExcelFile(file: MultipartFile, type: String) {
        workbook = WorkbookFactory.create(file.inputStream)
        if (type == "student") {
            addStudentUser(workbook)
        } else if (type == "title") {
            addTitle(workbook)
        } else if (type.startsWith("course")) {
            val collegeId = type.replace("course", "").toLong()
            addCourse(workbook, collegeId)
        } else if (type.startsWith("relationOfCourseAndCollege")) {
            val collegeId = type.replace("relationOfCourseAndCollege", "").toLong()
            addCourseAndCollegeTargetRelation(workbook, collegeId)
        } else if (type.startsWith("knowledgeAndCourseTar")) {
            val courseId = type.replace("knowledgeAndCourseTar", "").toLong()
            addCourseTargetAndKnowledgeRelation(workbook, courseId)
        }
    }

    private fun addTitle(workbook: Workbook) {

        val sheet = workbook.getSheet("试题信息") ?: throw ResultException("文件为空", 500)
        var continueCount = 0
        for (row in sheet) {
            if (row == null) {
                continue
            }
            var cellString = ""
            continueCount++
            if (continueCount == 1) {
                continue
            }
            if (isRowEmpty(row)) {
                break
            }
            for (cell in row) {
                cell.cellType = CellType.STRING
                cellString += "$cell$"
            }
            val list = cellString.split('$')
            val title = Title()
            title.title = list[0]
            title.category = list[1]
            title.difficulty = list[2].toDouble()
            title.answer = list[3]
            title.analysis = list[4]
            title.sectionA = list[5]
            title.sectionB = list[6]
            title.sectionC = list[7]
            title.sectionD = list[8]
            title.orderd = list[9].toBoolean()
            title.knowledgeId = list[10].toLong()
            title.addTime = Date(System.currentTimeMillis()).toString()

            println("list = $title")
        }
    }

    /**
     * 进行学生添加功能
     * @param workbook Workbook
     */
    private fun addStudentUser(workbook: Workbook) {
        val sheet = workbook.getSheet("学生信息") ?: throw ResultException("文件为空", 500)
        val encoder = BCryptPasswordEncoder()
        var continueCount = 0
        for (row in sheet) {
            if (row == null) {
                continue
            }
            var cellString = ""
            continueCount++
            if (continueCount == 1) {
                continue
            }
            if (isRowEmpty(row)) {
                break
            }
            for (cell in row) {
                cell.cellType = CellType.STRING
                cellString += "$cell$"
            }
            val list = cellString.split('$')
            val student = Student()
            student.name = list[0]
            student.studentNumber = list[1]
            student.classId = list[2].toLong()

            val user = User()
            user.username = student.studentNumber
            user.password = encoder.encode("111111")
            val newUser = userRepository.save(user)
            student.userId = newUser.id
            studentRepository.save(student)
            val userAndRole = UserAndRole()
            userAndRole.userId = newUser.id
            // roleId 3 学生
            userAndRole.roleId = 3
            userAndRoleRepository.saveAndFlush(userAndRole)
        }
    }

    private fun isRowEmpty(row: Row): Boolean {
        var c = row.firstCellNum
        while (c < row.lastCellNum) {
            val cell = row.getCell(c.toInt())
            if (cell != null && cell.cellType != CellType.BLANK) {
                return false
            }
            c++
        }
        return true
    }

    /**
     * 添加课程
     */
    private fun addCourse(workbook: Workbook, collegeId: Long) {
        val sheet = workbook.getSheet("课程信息") ?: throw ResultException("文件为空", 500)
        val encoder = BCryptPasswordEncoder()
        var continueCount = 0
        for (row in sheet) {
            if (row == null) {
                continue
            }
            var cellString = ""
            continueCount++
            if (continueCount == 1) {
                continue
            }
            if (isRowEmpty(row)) {
                break
            }
            for (cell in row) {
                cell.cellType = CellType.STRING
                cellString += "$cell$"
            }
            val list = cellString.split('$')
            val course = Course()
            course.name = list[0]
            course.direction = list[1]
            course.percent = list[2].toFloat()
            course.collegeId = collegeId
            courseRepository.saveAndFlush(course)
        }
    }


    /**
     * 添加课程与专业目标关系
     */
    private fun addCourseAndCollegeTargetRelation(workbook: Workbook, collegeId: Long) {
        val sheet = workbook.getSheet("课程与专业目标关系信息") ?: throw ResultException("文件为空", 500)
        val encoder = BCryptPasswordEncoder()
        var continueCount = 0
        var courseList = ArrayList<String>()
        for (row in sheet) {
            if (row == null) {
                continue
            }
            var cellString = ""
            continueCount++
            if (continueCount == 1) {
                for (cell in row) {
                    cell.cellType = CellType.STRING
                    var temp = cell.stringCellValue.split("/")
                    courseList.add(temp[1])
                }
                continue
            }
            if (isRowEmpty(row)) {
                break
            }
            var count = 0
            var collegeTargetId = 0L
            for (cell in row) {
                if (count == 0) {
                    cell.cellType = CellType.STRING
                    println("The cell value is " + cell.stringCellValue)
                    var temp = cell.stringCellValue.split("/")
                    collegeTargetId = temp[1].toLong()
                    count++
                    continue
                }
                cell.cellType = CellType.STRING
                cellString += "$cell$"
                count++
            }
            val list = cellString.split('$')
            var index = 0
            courseList.forEach { item ->
                val courseAndCollege = CourseAndCollege()
                courseAndCollege.courseId = item.toLong()
                courseAndCollege.collegeTargetId = collegeTargetId
                courseAndCollege.percent = list[index].toFloat()
                courseAndCollege.collegeId = collegeId
                courseAndCollegeRepository.saveAndFlush(courseAndCollege)
                index++
            }
        }
    }

    /**
     * 添加课程目标与知识点关系
     */
    private fun addCourseTargetAndKnowledgeRelation(workbook: Workbook, courseId: Long) {
        val sheet = workbook.getSheet("课程目标与知识点关系信息") ?: throw ResultException("文件为空", 500)
        val encoder = BCryptPasswordEncoder()
        var continueCount = 0
        var knowledgeList = ArrayList<String>()
        for (row in sheet) {
            if (row == null) {
                continue
            }
            var cellString = ""
            continueCount++
            // 从表头中取出知识点的id信息
            if (continueCount == 1) {
                for (cell in row) {
                    cell.cellType = CellType.STRING
                    var temp = cell.stringCellValue.split("/")
                    knowledgeList.add(temp[1])
                }
                continue
            }
            if (isRowEmpty(row)) {
                break
            }
            var count = 0
            // 迭代每一列的第一格，从中取出课程目标id
            var courseTargetId = 0L
            for (cell in row) {
                if (count == 0) {
                    cell.cellType = CellType.STRING
                    println("The cell value is " + cell.stringCellValue)
                    var temp = cell.stringCellValue.split("/")
                    courseTargetId = temp[1].toLong()
                    count++
                    continue
                }
                cell.cellType = CellType.STRING
                cellString += "$cell$"
                count++
            }
            val list = cellString.split('$')
            var index = 0
            // knowledgeList中存放的就是知识点id
            knowledgeList.forEach { item ->
                var courseAndKnowledge = CourseTarAndKnowledge()
                courseAndKnowledge.courseId = courseId
                courseAndKnowledge.courseTargetId = courseTargetId
                courseAndKnowledge.knowledgeId = item.toLong()
                courseAndKnowledge.percent = list[index].toFloat()
                courseTarAndKnowledgeRepository.saveAndFlush(courseAndKnowledge)
                index++
            }
        }
    }


    /**
     * 创建 student 模板
     * @return FileOutputStream
     */
    override fun createTemplateOfStudent(): File {
        val workbook = XSSFWorkbook()
        val studentSheet = workbook.createSheet("学生信息")
        val classSheet = workbook.createSheet("班级信息")
        val studentRow = studentSheet.createRow(0)
        val classRow = classSheet.createRow(0)
        val studentHeader = mutableListOf<String>("姓名", "学号", "班级id")
        val classHeader = mutableListOf<String>("id", "班级")
        // 设置学生sheet表头
        addTableHeader(studentRow, studentHeader)
        addTableHeader(classRow, classHeader)

        val classList = classRepository.findAll()

        // 写入班级id和班级的数据
        for (i in 0 until classList.size) {
            val classInfoRow = classSheet.createRow(i + 1)
            for (j in 0 until 2) {
                val classInfoCell = classInfoRow.createCell(j)
                if (j == 0) {
                    classInfoCell.cellType = CellType.NUMERIC
                    classInfoCell.setCellValue(classList[i].id.toString())
                }
                if (j == 1) {
                    classInfoCell.setCellValue(classList[i].name)
                    classInfoCell.cellType = CellType.STRING
                }
            }
        }
        val os = FileOutputStream("d:/excel测试.xlsx")
        workbook.write(os)
        val file = File("d:/excel测试.xlsx")
        return file
    }

    override fun createTemplateOfTitle(courseId: Long): File {

        val workbook = XSSFWorkbook()
        val titleSheet = workbook.createSheet("试题信息")
        val knowledgeSheet = workbook.createSheet("知识点信息")
        val chapterSheet = workbook.createSheet("章节信息")
        val titleRow = titleSheet.createRow(0)
        val knowledgeRow = knowledgeSheet.createRow(0)
        val chapterRow = chapterSheet.createRow(0)
        val titleHeader = mutableListOf(
                "题目",
                "题型(1 选择题，2填空题，3简单题，编程题和算法题请从网页添加，暂不支持批量导入)",
                "难度(0~1)",
                "答案",
                "分析",
                "选项A",
                "选项B",
                "选项C",
                "选项D",
                "答案是否有序",
                "知识点ID"
        )
        val knowledgeHeader = mutableListOf("知识点id", "知识点", "是否重点 (1 是/ 0 否)", "是否难点(1 是/ 0 否)", "章节id")
        val chapterHeader = mutableListOf("章节id", "章节名称")
        addTableHeader(titleRow, titleHeader)
        addTableHeader(knowledgeRow, knowledgeHeader)
        addTableHeader(chapterRow, chapterHeader)
        val knowledgeList = knowledgeRepository.findByCourseId(courseId)
        for (i in 0 until knowledgeList.size) {
            val knowledgeRow = knowledgeSheet.createRow(i + 1)
            for (j in 0 until knowledgeHeader.size) {
                val cell = knowledgeRow.createCell(j)
                when (j) {
                    0 -> {
                        cell.setCellValue(knowledgeList[i].id.toString())
                    }
                    1 -> {
                        cell.setCellValue(knowledgeList[i].name)
                    }
                    2 -> {
                        val isImp = if (knowledgeList[i].isImportant) {
                            1
                        } else {
                            0
                        }
                        cell.setCellValue(isImp.toString())
                    }
                    3 -> {
                        val isDiff = if (knowledgeList[i].isDifficult) {
                            1
                        } else {
                            0
                        }
                        cell.setCellValue(isDiff.toString())
                    }
                    4 -> {
                        val chapterId = knowledgeList[i].chapterId
                        cell.setCellValue(chapterId.toString())
                    }
                }
            }
        }

        val chapterList = chapterRepository.findAll()

        for (i in 0 until chapterList.size) {
            val chapterRow = chapterSheet.createRow(i + 1)
            for (j in 0 until chapterHeader.size) {
                val cell = chapterRow.createCell(j)
                if (j == 0) {
                    cell.setCellValue(chapterList[i].id.toString())
                }
                if (j == 1) {
                    cell.setCellValue(chapterList[i].name)
                }
            }
        }
        val os = FileOutputStream("d:/title.xlsx")
        workbook.write(os)
        val file = File("d:/title.xlsx")
        return file
    }

    override fun createTemplateOfChapter(): File {
        val workbook = XSSFWorkbook()
        val chapterSheet = workbook.createSheet("章节信息")
        val courseSheet = workbook.createSheet("课程信息")
        val chapterRow = chapterSheet.createRow(0)
        val courseRow = courseSheet.createRow(0)
        val chapterHeader = mutableListOf(
                "章节名称",
                "是否重点 (1 是/ 0 否)",
                "是否难点(1 是/ 0 否)",
                "课程id"
        )
        val courseHeader = mutableListOf("课程id", "课程名称")
        addTableHeader(chapterRow, chapterHeader)
        addTableHeader(courseRow, courseHeader)
        val courseList = courseRepository.findAll()
        for (i in 0 until courseList.size) {
            val knowledgeRow = courseSheet.createRow(i + 1)
            for (j in 0 until 4) {
                val cell = knowledgeRow.createCell(j)
                when (j) {
                    0 -> {
                        cell.setCellValue(courseList[i].id.toString())
                    }
                    1 -> {
                        cell.setCellValue(courseList[i].name)
                    }

                }
            }
        }

        val os = FileOutputStream("d:/course.xlsx")
        workbook.write(os)
        return File("d:/course.xlsx")


    }

    override fun createTemplateOfCourse(): File {
        val workbook = XSSFWorkbook()
        val courseSheet = workbook.createSheet("课程信息")
        val courseRow = courseSheet.createRow(0)
        val courseHeader = mutableListOf<String>("课程名", "是否为公共课", "百分比")
        // 设置学生sheet表头
        addTableHeader(courseRow, courseHeader)

        val os = FileOutputStream("d:/课程.xlsx")
        workbook.write(os)
        val file = File("d:/课程.xlsx")
        return file
    }

    override fun createTemplateOfCourseAndCollegeTargetRelation(collegeId: Long): File {
        val workbook = XSSFWorkbook()
        val relationSheet = workbook.createSheet("课程与专业目标关系信息")
        // 设置sheet横表头
        val relationRow = relationSheet.createRow(0)
        val courseList = courseRepository.findByCollegeId(collegeId)
        val relationHeader = courseList.map { item ->
            return@map item.name + '/' + item.id
        }
        addRowTableHeader(relationRow, relationHeader)

        // 设置sheet列表头
        val collegeTargetList = collegeTargetRepository.findByCollegeId(collegeId)
        val relationColumn = collegeTargetList.map { item ->
            return@map item.name + '/' + item.id
        }
        addColumnTableHeader(relationSheet, relationColumn)

        // 生成文件
        val os = FileOutputStream("d:/课程与专业目标关系.xlsx")
        workbook.write(os)
        val file = File("d:/课程与专业目标关系.xlsx")
        return file
    }

    override fun createTemplateOfCourseTargetAndKnowledgeRelation(courseId: Long): File {
        val workbook = XSSFWorkbook()
        val relationSheet = workbook.createSheet("课程目标与知识点关系信息")
        // 设置sheet横表头
        val relationRow = relationSheet.createRow(0)
        val knowledgeList = knowledgeRepository.findByCourseId(courseId)
        val relationHeader = knowledgeList.map { item ->
            return@map item.name + '/' + item.id
        }
        addRowTableHeader(relationRow, relationHeader)


        // 设置sheet列表头

        val courseTargetList = courseTargetRepository.findByCourseId(courseId)
        if (courseTargetList != null) {
            val relationColumn = courseTargetList.map { item ->
                return@map item.name + '/' + item.id
            }
            addColumnTableHeader(relationSheet, relationColumn)
        }
        // 生成文件
        val os = FileOutputStream("d:/课程与专业目标关系.xlsx")
        workbook.write(os)
        val file = File("d:/课程与专业目标关系.xlsx")
        return file
    }


    /**
     * 给 excel 添加横向表头 顶格起
     * @param row XSSFRow 所属行
     * @param header List<String> 表头内容
     */
    private fun addTableHeader(row: XSSFRow, header: List<String>) {
        for (i in 0 until header.size) {
            val cell = row.createCell(i)
            cell.setCellValue(header[i])
        }
    }

    /**
     * 给 excel 添加横向表头
     * @param row XSSFRow 所属行
     * @param header List<String> 表头内容
     */
    private fun addRowTableHeader(row: XSSFRow, header: List<String>) {
        for (i in 1 until header.size + 1) {
            val cell = row.createCell(i)
            cell.setCellValue(header[i-1])
        }
    }

    /**
     * 给 excel 添加表头 列表头，空出第一格
     * @param row XSSFRow 所属行
     * @param header List<String> 表头内容
     */
    private fun addColumnTableHeader(sheet: XSSFSheet, header: List<String>) {
        for (i in 1 until header.size + 1) {
            val row = sheet.createRow(i)
            val cell = row.createCell(0)
            cell.setCellValue(header[i - 1])
        }
    }
}



