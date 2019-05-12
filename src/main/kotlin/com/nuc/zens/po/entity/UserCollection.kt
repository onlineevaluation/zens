package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "nuc_tracking_collection")
class UserCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var userId: Long = 0
    var resouceId: Long = 0
    var userName: String = ""
    var addTime: String? = null
    var type: String = ""
    var url: String = ""
    var title: String = ""
}