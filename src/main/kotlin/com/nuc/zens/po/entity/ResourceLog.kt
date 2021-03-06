package com.nuc.zens.po.entity

import javax.persistence.*

/**
 * 资源对该班级应该完成的时间段
 */
@Entity
@Table(name = "nuc_tracking_resource_log")
class ResourceLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var studentId: Long = 0
    var resourceId: Long = 0
    var time: Long = 0
    var name: String ?= ""
}