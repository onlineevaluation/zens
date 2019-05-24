package com.nuc.zens.controller.admin

import com.nuc.zens.po.admin.DirectionResponse
import com.nuc.zens.po.entity.Direction
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
import com.nuc.zens.service.admin.DirectionService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 专业管理
 */

@RestController
@RequestMapping("/direction")
class DirectionController {
    @Autowired
    private lateinit var directionService: DirectionService
    @Autowired
    private lateinit var collegeService: CollegeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollege(@RequestBody direction: Direction): Result {
        println("direction ${direction}")
        directionService.save(direction)
        val msg = directionService.findAll()
        return ResultUtils.success(200, "插入方向成功", msg)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val directionList = directionService.findAll()
        val msg = directionList.map { (key, value) ->
            val collegeName = collegeService.findOne(key).name!!
            var directionResponse = DirectionResponse()
            directionResponse.collegeName = collegeName
            directionResponse.directionList =value
            return@map directionResponse
        }
        return ResultUtils.success(200, "获取方向列表", msg)
    }
}