package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "nuc_tracking_college_target")
@JsonIgnoreProperties(value = ["id"])

class CollegeTarget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var percent: Float = 0f
    var name: String = ""
    var collegeId: Long = 0
}