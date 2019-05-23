package com.nuc.zens.po.admin

class CollegeAbililityResponse {
    var collegeId: Long = 0
    var collegeName: String = ""
    lateinit var collegeAbilityList: List<CAResponse>
}