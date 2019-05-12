package com.nuc.zens.po.entity

import javax.persistence.*

/**
 * 知识点对该班级应该完成的时间段
 */
@Entity
@Table(name = "nuc_tracking_knowledge_class")
class KnowledgeClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var courseId: Long = 0
    var classId: Long = 0
    var knowledgeId: Long = 0
    var startTime: String = ""
    var endTime: String = ""
}