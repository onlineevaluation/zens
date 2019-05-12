package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*


@Entity
@Table(name = "uek_acdemic_chapter")
@JsonIgnoreProperties(value = ["id"])
class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    private lateinit var num: String
    private lateinit var name: String
    var isDifficult: Long = 0
    var isImportant: Long = 0
    var courseId: Long = 0
    var percent: Float = 0f

}
