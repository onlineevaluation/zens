package com.nuc.zens.po.entity

import javax.persistence.*

@Entity
@Table(name = "uek_acdemic_teacher")
class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var jobNumber: String? = null
    var name: String? = null
    var hiredate: java.sql.Date? = null
    var status: Long = 0
    var positionId: Long = 0
    var userId: Long = 0
    var sex: Long = 0
    var tel: String? = null
    var photo: String? = null

}
