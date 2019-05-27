package com.nuc.zens.controller.admin

import com.nuc.zens.po.admin.CollegeResponse
import com.nuc.zens.po.entity.CollegeTarget
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
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
    private lateinit var collegeTargetService: CollegeTargetService
    @Autowired
    private lateinit var collegeService: CollegeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollege(@RequestBody collegeTargetList: List<CollegeTarget>): Result {
        collegeTargetService.saveAll(collegeTargetList)
        val res = ArrayList<CollegeResponse>()
        val targetList = collegeTargetService.getList()
        targetList.forEach { (key, value) ->
            val collegeResponse = CollegeResponse()
            collegeResponse.collegeId = key
            collegeResponse.collegeTargetList = value
            collegeResponse.collegeName=collegeService.findOne(key).name!!
            res.add(collegeResponse)
        }
        return ResultUtils.success(200, "插入成功", res)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val res = ArrayList<CollegeResponse>()
        val targetList = collegeTargetService.getList()
        targetList.forEach { (key, value) ->
            val collegeResponse = CollegeResponse()
            collegeResponse.collegeId = key
            collegeResponse.collegeTargetList = value
            collegeResponse.collegeName=collegeService.findOne(key).name!!
            res.add(collegeResponse)
        }
        return ResultUtils.success(200, "获取列表", res)
    }

    @GetMapping("/getByCollegeId")
    fun getByCollegeId(collegeId:Long):Result{
        val msg =collegeTargetService.findByCollegeId(collegeId)
        return ResultUtils.success(200, "获取专业指标列表", msg)
    }
}