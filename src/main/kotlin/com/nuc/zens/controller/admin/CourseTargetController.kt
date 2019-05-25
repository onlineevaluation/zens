package com.nuc.zens.controller.admin

import com.nuc.zens.po.admin.CourseTargetRes
import com.nuc.zens.po.entity.CourseTarget
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
import com.nuc.zens.service.point.CourseTargetService
import com.nuc.zens.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 课程目标管理
 */

@RestController
@RequestMapping("/courseTarget")
class CourseTargetController {
    @Autowired
    private lateinit var courseTargetService:CourseTargetService
    @Autowired
    private lateinit var collegeService: CollegeService
    @Autowired
    private lateinit var courseService: CollegeService

    @PostMapping("/insert")
    fun insertCollege(@RequestBody courseTargetList: List<CourseTarget>): Result {
        courseTargetService.saveAll(courseTargetList)
        val res = ArrayList<CourseTargetRes>()
        val targetList = courseTargetService.findAll()
        targetList.forEach { (key, value) ->
            val courseTargetRes = CourseTargetRes()
            courseTargetRes.courseName=courseService.findOne(key).name!!
            courseTargetRes.courseTargetList=value
            res.add(courseTargetRes)
        }
        return ResultUtils.success(200, "插入成功", res)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val res = ArrayList<CourseTargetRes>()
        val targetList = courseTargetService.findAll()
        targetList.forEach { (key, value) ->
            val courseTargetRes = CourseTargetRes()
            courseTargetRes.courseName=courseService.findOne(key).name!!
            courseTargetRes.courseTargetList=value
            res.add(courseTargetRes)
        }
        return ResultUtils.success(200, "获取列表", res)
    }

}