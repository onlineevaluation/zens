package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

/**
 * 考核方式
 */
@Entity
@Table(name = "nuc_tracking_daily_way")
@JsonIgnoreProperties(value = ["id"])
class DailyWay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    var name: String=""
    var courseId: Long = 0
    var percent: Float = 0f
    var type:String="1"
    var resourceId: Long = 0

}