package com.nuc.zens.controller.relation

import com.nuc.zens.po.relation.CollegeAndAbility
import com.nuc.zens.service.relation.CollegeAndAbilityService
import com.nuc.zens.result.Result
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/collegeAndability")
class CollegeAndAbilityController {
    @Autowired
    private lateinit var collegeAndAbilityService: CollegeAndAbilityService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollegeAndAbility(@RequestBody collegeAndAbility: CollegeAndAbility): Result {
        val msg = collegeAndAbilityService.save(collegeAndAbility)
        return ResultUtils.success(200, "插入成功", msg)
    }
}