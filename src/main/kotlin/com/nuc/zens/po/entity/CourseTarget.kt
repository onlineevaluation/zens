package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 课程目标
 */
@Entity
@Table(name = "nuc_tracking_course_target")
@JsonIgnoreProperties(value = ["id"])
class CourseTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var percent: Float = 0f
    var name: String=""
    private lateinit var about: String
    var courseId: Long = 0
    var indecatorId: Long = 0
}