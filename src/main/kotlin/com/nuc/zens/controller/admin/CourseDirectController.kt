package com.nuc.zens.controller.admin

import com.nuc.zens.po.admin.CourseDirect
import com.nuc.zens.po.admin.CourseDirectResponse
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
import com.nuc.zens.service.admin.CourseDirectService
import com.nuc.zens.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/courseDirect")
class CourseDirectController {
    @Autowired
    private lateinit var courseDirectService: CourseDirectService
    @Autowired
    private lateinit var collegeService: CollegeService

    @PostMapping("/insert")
    fun insertCollege(@RequestBody courseDirect: CourseDirect): Result {
        courseDirectService.save(courseDirect)
        val msg = courseDirectService.findAll()
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val temp = courseDirectService.findAll()
        val msg = temp.map {
            var courseDirectResponse = CourseDirectResponse()
            courseDirectResponse.collegeName = collegeService.findOne(it.collegeId).major!!
            courseDirectResponse.courseDirect = it
            return@map courseDirectResponse
        }
        return ResultUtils.success(200, "获取列表", msg)
    }
}