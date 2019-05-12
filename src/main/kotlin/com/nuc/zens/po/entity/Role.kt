package com.nuc.zens.po.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.*

/**
 * 角色表
 */
@Entity
@Table(name = "uek_privilege_role")
class Role : GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    lateinit var name: String

    lateinit var about: String


    override fun getAuthority(): String {
        return name
    }

}