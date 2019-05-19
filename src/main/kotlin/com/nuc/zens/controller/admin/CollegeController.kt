package com.nuc.tracking.teacherend.controller.admin

import com.nuc.tracking.teacherend.po.admin.College
import com.nuc.tracking.teacherend.result.Result
import com.nuc.tracking.teacherend.service.admin.CollegeService
import com.nuc.tracking.teacherend.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 专业管理
 */

@RestController
@RequestMapping("/college")
class CollegeController {
    @Autowired
    private lateinit var collegeService: CollegeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollege(@RequestBody college: College): Result {
        val msg = collegeService.save(college)
        return ResultUtils.success(200, "插入成功", msg)
    }
}