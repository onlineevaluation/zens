package com.nuc.zens.controller.relation


import com.nuc.zens.po.admin.DailyWayResponse
import com.nuc.zens.service.point.DailyWayService
import com.nuc.zens.po.entity.DailyWay
import com.nuc.zens.result.Result
import com.nuc.zens.service.point.CourseService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/dailyWay")
class DailyWayController {
    @Autowired
    private lateinit var dailyWayService: DailyWayService
    @Autowired
    private lateinit var courseService: CourseService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertDailyWay(@RequestBody dailyWayList: List<DailyWay>): Result {
        dailyWayService.save(dailyWayList)
        val temp = dailyWayService.findAll()
        val msg = temp.map { (key, value) ->
            var dailyWayResponse = DailyWayResponse()
            dailyWayResponse.courseName = courseService.findOne(key).name
            dailyWayResponse.dailyWayList = value
            return@map dailyWayResponse
        }
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/getAll")
    fun getAll(): Result {
        val temp = dailyWayService.findAll()
        val msg = temp.map { (key, value) ->
            var dailyWayResponse = DailyWayResponse()
            dailyWayResponse.courseName = courseService.findOne(key).name
            dailyWayResponse.dailyWayList = value
            return@map dailyWayResponse
        }
        return ResultUtils.success(200, "获取考核方式成功", msg)
    }
}