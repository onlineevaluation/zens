package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.UserService
import com.nuc.zens.util.ResultUtils
import com.nuc.zens.vo.StudentParam
import com.nuc.zens.vo.TeacherRoleParam
import com.nuc.zens.vo.UserParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author 杨晓辉 2018/2/1 15:47
 * 用户中心请求
 */
@RestController
@RequestMapping("/user")
class UserController {

    @Autowired
    private lateinit var userService: UserService

    /**
     * 用户登录
     * @param userParam user参数
     * @return 返回 token 包含 用户名 用户id 学生所在班级
     */
    @PostMapping("/login")
    fun login(@RequestBody userParam: UserParam): Result {
        val token = userService.login(userParam.username, userParam.password)
        return ResultUtils.success(200, "登录成功", token)
    }

    /**
     * @param id 用户id
     * 通过用户id获取详细信息
     */
    @GetMapping("/profile/{id}")
    fun userProfile(@PathVariable id: Long): Result {
        val profile = userService.profile(id)
        return ResultUtils.success(data = profile)
    }

    /**
     * 通过学生id获取学生信息
     * @return Result
     */
    @GetMapping("/profile/student/{studentId}")
    fun studentProfile(@PathVariable("studentId") studentId: Long): Result {
        val studentProfile = userService.studentProfile(studentId)
        return ResultUtils.success(data = studentProfile)
    }

    /**
     * 通过教师id获取教师信息
     * @param teacherId  teacherId: Long
     * @return Result
     */
    @GetMapping("/profile/teacher/{teacherId}")
    fun teacherProfile(@PathVariable("teacherId") teacherId: Long): Result {
        val teacherProfileInfo = userService.teacherProfile(teacherId)
        return ResultUtils.success(data = teacherProfileInfo)
    }

    /**
     * 获取所有的学生
     * @return Result
     */
    @GetMapping("/students/{page}")
    fun allStudents(@PathVariable("page") page: Int): Result {
        val students = userService.findAllStudent(page)
        return ResultUtils.success(data = students)

    }

    /**
     * 获取所有的教师
     * @return Result
     */
    @GetMapping("/teachers/{page}")
    fun allTeacher(@PathVariable("page") page: Int): Result {
        val teachers = userService.findAllTeacher(page)
        return ResultUtils.success(data = teachers)
    }


    @PostMapping("/student")
    fun addStudent(@RequestBody studentParam: StudentParam): Result {
        println("studentParam = ${studentParam}")
        userService.addStudent(studentParam.studentNum, studentParam.studentName, studentParam.classId)
        return ResultUtils.success()
    }

    @DeleteMapping("/student/{studentId}")
    fun deleteStudent(@PathVariable(name = "studentId") studentId: Long) {
        println("id = $studentId")

    }

    @GetMapping("/student/{studentId}")
    fun getStudentProfile(@PathVariable(name = "studentId") studentId: Long): Result {
        val student = userService.getStudentProfile(studentId)
        return ResultUtils.success(data = student, message = "获取成功")
    }

}