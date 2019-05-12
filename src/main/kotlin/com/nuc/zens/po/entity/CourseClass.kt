package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "nuc_tracking_course_class")
@JsonIgnoreProperties(value = ["id"])
class CourseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var teacherId: Long = 0
    var classId: Long = 0
    var courseId: Long = 0
    var startTime: String = ""
    var endTime: String = ""
}