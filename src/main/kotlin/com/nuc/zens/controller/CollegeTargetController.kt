package com.nuc.zens.controller

import com.nuc.tracking.teacherend.po.entity.CollegeTarget
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.point.CollegeTargetService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 专业管理-管理员
 */

@RestController
@RequestMapping("/collegeTarget")
class CollegeTargetController {
    @Autowired
    private lateinit var collegeTargetService:CollegeTargetService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollegeTarget(@RequestBody collegeTarget:CollegeTarget): Result {
        val msg = collegeTargetService.save(collegeTarget)
        return ResultUtils.success(200, "添加新的专业目标成功", msg)
    }
}