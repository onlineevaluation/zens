package com.nuc.zens.repository

import com.nuc.zens.po.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018/2/3 15:16
 */
@Repository
interface StudentRepository : JpaRepository<Student, Long> {
    /**
     * 通过 studentNumber 查找
     * @param studentNumber studentNumber
     */
    fun findByStudentNumber(studentNumber: String): Student?

    /**
     * 通过班级号查找学生
     * @param classId 班级号
     *
     */
    fun findStudentsByClassId(classId: Long): ArrayList<Student>

    /**
     * 通过班级 id 获取人数
     * @param classId Long
     * @return Long 班级总人数
     */
    fun countByClassId(classId: Long):Long

    /**
     * 通过 user id 查找 student
     * @param userId Long
     * @return Student
     */
    fun findByUserId(userId:Long):Student
}