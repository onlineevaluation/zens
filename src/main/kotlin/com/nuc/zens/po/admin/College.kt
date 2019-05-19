package com.nuc.tracking.teacherend.po.admin

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*


@Entity
@Table(name = "nuc_admin_college")
@JsonIgnoreProperties(value = ["id"])
class College {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var major: String? = null
    var name: String? = null
    var summary: String? = null
    var universityId: Long = 0

}
