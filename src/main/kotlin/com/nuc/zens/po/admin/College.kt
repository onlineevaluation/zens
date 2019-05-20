package com.nuc.zens.po.admin

import javax.persistence.*

@Entity
@Table(name = "nuc_admin_college")
class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var major: String? = null
    var name: String? = null
    var summary: String? = null
    var universityId: Long = 0

    override fun toString(): String {
        return "College(id=$id, major=$major, name=$name, summary=$summary, universityId=$universityId)"
    }


}
