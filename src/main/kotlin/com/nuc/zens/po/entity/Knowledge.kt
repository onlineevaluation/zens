package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 课程对应的知识点
 */
@Entity
@Table(name = "uek_acdemic_knowledge")
class Knowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var num: String? = null
    var name: String? = null
    var isDifficult: Boolean = false
    var isImportant: Boolean = false
    var video: String? = null
    var courseId: Long = 0
    var clickNum: Long? = 0
    var chapterId: Long = 0
    var percent:Float = 0f

}
