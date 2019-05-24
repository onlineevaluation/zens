package com.nuc.zens.po.admin

import com.nuc.zens.po.entity.Direction

class DirectionResponse {
    var collegeName: String = ""
    lateinit var directionList: List<Direction>
}