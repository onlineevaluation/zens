package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@Entity
@Table(name = "uek_acdemic_course")
@JsonIgnoreProperties(value = ["id"])
class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var num: String=""
    var name: String=""
    var introduce: String=""

    lateinit var coverImage: String
    lateinit var level:String
    lateinit var direction:String
    lateinit var score:String
    lateinit var classHour:String
    var requirement:String?=null


}
