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
    var sex: String? = null
    override fun toString(): String {
        return "TeacherInfo(id=$id, name='$name', teacherNumber='$teacherNumber', position='$position', positionId=$positionId, sex=$sex)"
    }


}

/**
 * 学生详细信息
 * @property id Long
 * @property email String?
 * @property idcard String?
 * @property name String
 * @property phone String?
 * @property studentNumber String
 * @property qq String?
 * @property classNumber String?
 */
class StudentProfileInfo {
    var id: Long = 0L
    var email: String? = null
    var idcard: String? = null
    lateinit var name: String
    var phone: String? = null
    /**
     * 学号
     */
    lateinit var studentNumber: String

    var qq: String? = null
    /**
     * 班级号
     */
    var classNumber: String? = null
}

/**
 * 教师详细信息
 * @property id Long
 * @property name String
 * @property jobNumber String
 * @property sex String
 * @property tel String?
 */
class TeacherProfileInfo {
    var id: Long = 0
    lateinit var name: String
    lateinit var jobNumber: String
    lateinit var sex: String
    var tel: String? = null
    lateinit var position: String
}

/**
 * 教师权限管理
 * @property id Long
 * @property name String
 * @property jobNumber String
 * @property role String
 */
class TeacherRoleInfo {
    var id: Long = 0
    lateinit var name: String
    lateinit var jobNumber: String
    lateinit var role: String
    lateinit var position: String
}

/**
 * 试题信息
 * @property id Long
 * @property title String
 * @property answer String
 */
class TitleInfo {
    var id: Long = 0L
    lateinit var title: String
    lateinit var answer: String
    var knowledge: String? = null
    var difficulty: Double = 0.0
    var analysis: String? = null
    var sectionA: String? = null
    var sectionB: String? = null
    var sectionC: String? = null
    var sectionD: String? = null
    var course: String? = null
    var orderd: Long? = 1
    lateinit var category: String
}


class ClassInfo {
    var id: Long = 0L
    lateinit var name: String

    var classmateCount: Long = 0
}