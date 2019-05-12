package com.nuc.zens.po.relation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 课程目标和知识点的关系
 */
@Entity
@Table(name = "nuc_tracking_course_target_knowledge")
@JsonIgnoreProperties(value = ["id"])
class CourseTarAndKnowledge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var knowledgeId: Long = 0
    var courseTargetId:Long=0
    var percent: Float = 0f
}