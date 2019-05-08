package com.nuc.zens.service

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.Student
import com.nuc.zens.po.Teacher
import com.nuc.zens.vo.StudentInfo
import com.nuc.zens.vo.TeacherInfo
import com.nuc.zens.vo.UserProfileInfo

/**
 * @author 杨晓辉 2019/4/26 15:55
 */
interface UserService {


    /**
     * 通过用户名进行用户查找
     * @param username 学号
     * @param password 密码
     * @return HashMap 返回用户信息和token
     * @throws ResultException 当用户名称和密码不一致
     */
    @Throws(ResultException::class)
    fun login(username: String, password: String): String


    /**
     * 通过用户 id 获取用户信息
     */
    fun profile(id: Long): UserProfileInfo

    /**
     * 通过 student id 获取学生信息
     * @param studentId Long 学生id
     */
    fun studentProfile(studentId: Long): StudentInfo

    /**
     * 通过教师 id 获取学生
     * @param teacherId Long
     */
    fun teacherProfile(teacherId: Long)

    /**
     * 获取所有的学生
     * @return List<Student>
     */
    fun findAllStudent():List<StudentInfo>

    /**
     * 获取所有的教师
     * @return List<Teacher>
     */
    fun findAllTeacher():List<TeacherInfo>

    /**
     * 添加学生用户
     * @param studentNum String
     * @param studentName String
     * @param classId Long
     */
    fun addStudent(studentNum: String, studentName: String, classId: Long)
}