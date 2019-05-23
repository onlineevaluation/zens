package com.nuc.zens.vo


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