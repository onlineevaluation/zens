package com.nuc.zens.vo


/**
 * @author 杨晓辉 2019/4/8 12:00
 */

/**
 * 用户详细信息
 * @property name String 名字
 * @property number String 学号/工号
 * @property userId Long 用户id
 * @property classId Long 班级id
 */
class UserProfileInfo {
    lateinit var name: String
    lateinit var number: String
    var userId: Long = 0L
    var classId: Long = 0L
    /**
     * 身份id ，student id 或者 teacher id
     */
    var identity: Long = 0L

    override fun toString(): String {
        return "UserProfileInfo(name='$name', number='$number', userId=$userId, classId=$classId)"
    }
}

/**
 * 学生返回信息
 * @property name String 学生姓名
 * @property studentNumber String 学生学号
 * @property `class` String 班级名词
 * @property classId Long 班级id
 */
class StudentInfo {
    var id: Long = 0L
    lateinit var name: String
    lateinit var studentNumber: String
    lateinit var `class`: String
    var classId: Long = 0L
}

/**
 * 返回教师信息
 * @property id Long
 * @property name String
 * @property teacherNumber String
 * @property position String 职位
 * @property positionId Long 职位id
 */
class TeacherInfo {
    var id: Long = 0L
    lateinit var name: String
    lateinit var teacherNumber: String
    lateinit var position: String
    var positionId: Long = 0L
}
