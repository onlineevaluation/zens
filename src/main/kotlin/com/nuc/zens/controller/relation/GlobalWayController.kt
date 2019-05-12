package com.nuc.zens.controller.relation

import com.nuc.zens.service.point.GlobalWayService
import com.nuc.zens.po.entity.GlobalWay
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
@RequestMapping("/globalWay")
class GlobalWayController {
    @Autowired
    private lateinit var globalWayService: GlobalWayService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertGlobalWay(@RequestBody globalWay: GlobalWay): Result {
        val msg = globalWayService.save(globalWay)
        return ResultUtils.success(200, "插入成功", msg)
    }
}