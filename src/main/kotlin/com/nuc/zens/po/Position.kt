package com.nuc.zens.po

import javax.persistence.*

/**
 * @author 杨晓辉 2019/5/8 8:48
 */
@Entity
@Table(
    name = "uek_organization_position",
    indexes = [Index(name = "id", columnList = "id")]
)
class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    lateinit var name: String

    var duty: String? = null

    var department_id: Long? = 0

    var parentId: Long? = 0

    var role_id: Long? = 0
}