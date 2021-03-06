package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "uek_acdemic_ability")
class RAbility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var collegeId: Long = 0
    var name: String? = null
    var summary: String? = null
    var percent: Float = 0f
    var isDisable = false

}
