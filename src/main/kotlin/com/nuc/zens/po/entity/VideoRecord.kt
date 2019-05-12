package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "uek_acdemic_video_record")
@JsonIgnoreProperties(value = ["id"])
class VideoRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var userId: Long = 0
    var overtime: String? = null
    var knowledgeId: Long = 0
}