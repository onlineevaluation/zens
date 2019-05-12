package com.nuc.zens.po.relation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 课程目标和全局考核方式的关系：包括结课大作业和整学期考勤成绩
 * 同一课程的全局考核方式和需为1
 */
@Entity
@Table(name = "nuc_tracking_course_target_way")
@JsonIgnoreProperties(value = ["id"])
class CourseTarAndWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var typeName: String = ""
    var percent: Float = 0f
}