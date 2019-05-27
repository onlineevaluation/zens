package com.nuc.zens.po.admin

import com.nuc.zens.po.entity.DailyWay

class DailyWayResponse {
    var courseName: String = ""
    lateinit var dailyWayList:List<DailyWay>
}