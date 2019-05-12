package com.nuc.zens.po.relation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 知识点和日常考核方式的关系：包括小作业、小测验、资源学习等
 * 指在每个知识点都可进行的小规模大频率考核方式
 * 同一课程的日常考核方式占比和需为1
 */
@Entity
@Table(name = "nuc_tracking_knowledge_way")
@JsonIgnoreProperties(value = ["id"])
class KnowledgeAndWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var typeName: String = ""
    var percent: Float = 0f
}