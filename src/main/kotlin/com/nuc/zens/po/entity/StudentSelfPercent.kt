package com.nuc.zens.po.entity

import com.nuc.zens.po.Student

/**
 * 返回给教师端的班级学生信息
 */
class StudentSelfPercent {
    lateinit var student: Student
    var selfPercent = 0f
}