package com.nuc.zens.controller.relation

import com.nuc.zens.po.admin.GlobalWayResponse
import com.nuc.zens.service.point.GlobalWayService
import com.nuc.zens.po.entity.GlobalWay
import com.nuc.zens.result.Result
import com.nuc.zens.service.point.CourseService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/globalWay")
class GlobalWayController {
    @Autowired
    private lateinit var globalWayService: GlobalWayService

    @Autowired
    private lateinit var courseService: CourseService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertGlobalWay(@RequestBody globalWayList: List<GlobalWay>): Result {
        globalWayService.saveAll(globalWayList)
        val temp = globalWayService.findAll()
        val msg = temp.map { (key, value) ->
            val globalWayResponse = GlobalWayResponse()
            globalWayResponse.courseName = courseService.findOne(key).name
            globalWayResponse.globalList = value
            return@map globalWayResponse
        }
        return ResultUtils.success(200, "插入考核方式成功", msg)
    }

    @GetMapping("/getAll")
    fun getGlobalWays(): Result {
        val temp = globalWayService.findAll()
        val msg = temp.map { (key, value) ->
            val globalWayResponse = GlobalWayResponse()
            globalWayResponse.courseName = courseService.findOne(key).name
            globalWayResponse.globalList = value
            return@map globalWayResponse
        }
        return ResultUtils.success(200, "获取考核方式成功", msg)
    }
}