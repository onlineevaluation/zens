package com.nuc.zens.po.relation

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 毕业要求和专业目标的关系表
 */
@Entity
@Table(name = "nuc_tracking_college_ability")
@JsonIgnoreProperties(value = ["id"])
class CollegeAndAbility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var abilityId: Long = 0
    var collegeTargetId: Long = 0
    var percent: Float = 0f
}