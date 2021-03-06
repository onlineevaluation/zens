package com.nuc.zens.controller.relation

import com.nuc.zens.po.admin.CAResponse
import com.nuc.zens.po.admin.CollegeAbililityResponse
import com.nuc.zens.po.relation.CollegeAndAbility
import com.nuc.zens.service.relation.CollegeAndAbilityService
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
import com.nuc.zens.service.point.CollegeTargetService
import com.nuc.zens.service.point.RAbilityService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/collegeAndability")
class CollegeAndAbilityController {
    @Autowired
    private lateinit var collegeAndAbilityService: CollegeAndAbilityService
    @Autowired
    private lateinit var collegeService: CollegeService
    @Autowired
    private lateinit var collegeTargetService: CollegeTargetService
    @Autowired
    private lateinit var abilityService: RAbilityService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollegeAndAbility(@RequestBody collegeAndAbility: CollegeAndAbility): Result {
        val msg = collegeAndAbilityService.save(collegeAndAbility)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @PostMapping("/insertAll")
    fun insertAll(@RequestBody collegeAndAbilityList: List<CollegeAndAbility>): Result {
        val msg = collegeAndAbilityService.saveAll(collegeAndAbilityList)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/getAll")
    fun getAll(): Result {

        val msg = ArrayList<CollegeAbililityResponse>()
        var collegeAbilityList = collegeAndAbilityService.getAll()
        if (collegeAbilityList !== null) {
            collegeAbilityList.map { (key, value) ->
                var collegeAbililityResponse = CollegeAbililityResponse()
                collegeAbililityResponse.collegeId = key
                collegeAbililityResponse.collegeName = collegeService.findOne(key).name!!
                var tempList = ArrayList<CAResponse>()
                value.map { item ->
                    var caResponse = CAResponse()
                    caResponse.abilityId = item.abilityId
                    caResponse.abilityName = abilityService.findOne(item.abilityId).name!!
                    caResponse.collegeTargetId = item.collegeTargetId
                    caResponse.collegeTargetName = collegeTargetService.findOne(item.collegeTargetId).name
                    caResponse.percent = item.percent
                    caResponse.CAId = item.id
                    tempList.add(caResponse)
                }
                collegeAbililityResponse.collegeAbilityList=tempList
                msg.add(collegeAbililityResponse)
            }
        }

        return ResultUtils.success(200, "查找成功", msg)
    }
}