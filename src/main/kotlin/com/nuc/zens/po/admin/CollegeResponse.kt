package com.nuc.zens.po.admin

import com.nuc.zens.po.entity.CollegeTarget

class CollegeResponse {
    var collegeId: Long = 0
    var collegeName: String = ""
    lateinit var collegeTargetList: List<CollegeTarget>
}