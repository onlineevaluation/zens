package com.nuc.zens.service.impl

import com.nuc.zens.po.Student
import com.nuc.zens.po.User
import com.nuc.zens.repository.*
import com.nuc.zens.repository.point.CourseRepository
import com.nuc.zens.repository.point.KnowledgeRepository
import com.nuc.zens.service.FileService
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream

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
    private lateinit var chapterRepository: ChapterRepository

    override fun uploadExcelFile(file: MultipartFile, type: String) {
        val workbook = WorkbookFactory.create(file.inputStream)
        val sheet = workbook.getSheet("学生信息")
        val encoder = BCryptPasswordEncoder()
        for (row in sheet) {
            if (row == null) {
                continue
            }
            var cellString = ""
            var stopFlag = 0
            for (cell in row) {

                if (cell.cellType === CellType.BLANK) {
                    stopFlag = 1
                    break
                }
                cell.cellType = CellType.STRING
                cellString += "$cell$"
            }
            if (stopFlag == 1) {
                continue
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

    /**
     * 给 excel 添加表头
     * @param row XSSFRow 所属行
     * @param header List<String> 表头内容
     */
    private fun addTableHeader(row: XSSFRow, header: List<String>) {
        for (i in 0 until header.size) {
            val cell = row.createCell(i)
            cell.setCellValue(header[i])
        }
    }


}
