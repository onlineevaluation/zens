package com.nuc.zens.controller.admin

import com.nuc.zens.po.entity.CollegeTarget
import com.nuc.zens.result.Result
import com.nuc.zens.service.point.CollegeTargetService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 专业目标管理
 */

@RestController
@RequestMapping("/collegeTarget")
class CollegeTargetController {
    @Autowired
    private lateinit var collegeTargetService:CollegeTargetService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollege(@RequestBody collegeTargetList: List<CollegeTarget>): Result {
        collegeTargetService.saveAll(collegeTargetList)
        val msg = collegeTargetService.getList()
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val msg = collegeTargetService.getList()
        return ResultUtils.success(200, "获取列表", msg)
    }
}