package com.nuc.zens.po.entity


import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 该类不是课程目标，是课程所修的年级和方向
 */
@Entity
@Table(name = "uek_acdemic_course_plan")
@JsonIgnoreProperties(value = ["id"])
class CoursePlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var grade: Long = 0
    var subjectId: Long = 0

}
