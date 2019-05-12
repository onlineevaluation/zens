package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "uek_comment")
@JsonIgnoreProperties(value = ["id"])
class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var userId: Long = 0
    var videoId: Long = 0
    var userName: String = ""
    var commentTime: String? = null
    var content: String = ""

}
