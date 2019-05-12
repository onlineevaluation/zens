package com.nuc.zens.controller.relation


import com.nuc.zens.service.point.DailyWayService
import com.nuc.zens.po.entity.DailyWay
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
@RequestMapping("/dailyWay")
class DailyWayController {
    @Autowired
    private lateinit var dailyWayService: DailyWayService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertDailyWay(@RequestBody dailyWay: DailyWay): Result {
        val msg = dailyWayService.save(dailyWay)
        return ResultUtils.success(200, "插入成功", msg)
    }
}