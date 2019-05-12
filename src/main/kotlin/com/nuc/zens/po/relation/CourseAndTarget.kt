package com.nuc.zens.po.relation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 课程和课程目标的关系
 */
@Entity
@Table(name = "course_target")
@JsonIgnoreProperties(value = ["id"])
class CourseAndTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var courseTargetId: Long = 0
    var percent: Float = 0f
}