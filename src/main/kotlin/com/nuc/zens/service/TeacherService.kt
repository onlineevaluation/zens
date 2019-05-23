package com.nuc.zens.service

import com.nuc.zens.vo.TeacherRoleInfo

/**
 * @author 杨晓辉 2019/5/8 10:55
 */
interface TeacherService {


    /**
     * 添加新教师
     * @param teacherName String
     * @param teacherNumber String
     * @param positionId Long
     */
    fun addTeacher(teacherName: String, teacherNumber: String, positionId: Long, sex: Int)

    /**
     * 更新教师信息
     * @param teacherId Long
     * @param name String
     * @param jobNumber String
     * @param positionId Long
     * @param sex Int
     */
    fun updateTeacher(teacherId: Long, name: String, jobNumber: String, positionId: Long, sex: Int)

    /**
     * 查找所有的学生和相关权限
     * @return List<TeacherRoleInfo>
     */
    fun findAllTeacherRole():List<TeacherRoleInfo>
}