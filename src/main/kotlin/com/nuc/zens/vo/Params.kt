package com.nuc.zens.vo

import java.util.*


/**
 * @author 杨晓辉 2018-12-29 16:06
 * 用于接收前端参数的类
 * 所有的类采用data class
 * 所有的后缀采用 **param**
 */

/**
 * 用于接收页面的 `UserParam` 值
 * @param username 用户名
 * @param password 密码
 */
data class UserParam(
    val username: String,
    val password: String
)

/**
 * 接收 Course 的值
 * @property name String
 * @property introduce String
 * @constructor
 */
data class CourseParam(val name: String, val introduce: String)

/**
 * 接收新增学生参数
 * @property studentName String
 * @property studentNum String
 * @property classId Int
 * @constructor
 */
data class StudentParam(val studentName: String, val studentNum: String, val classId: Long)

/**
 * 新增教师参数
 * @property teacherName String
 * @property teacherNumber String
 * @property positionId Long
 * @constructor
 */
data class TeacherParam(val teacherName: String, val teacherNum: String, val positionId: Long, val sex: Int)

/**
 *
 * @property teacherId Long
 * @property roleIds Array<Int>
 * @constructor
 */
data class TeacherRoleParam(val teacherId: Long, val roleIds: Array<Int>)

/**
 * 获取所有的试题
 * @property title String
 * @property answer String
 * @property analysis String
 * @property difficulty Long
 * @property courseId Long
 * @property knowledgeId Long
 * @property isOrder Long
 * @property type String
 * @property a String
 * @property b String
 * @property c String
 * @property d String
 * @constructor
 */
data class TitleParam(
    val title: String, val answer: String,

    val analysis: String,
    val difficulty: Long,
    val courseId: Long,
    val knowledgeId: Long,
    val isOrder: Long,
    val category: String,
    val sectionA: String,
    val sectionB: String,
    val sectionC: String,
    val sectionD: String


)