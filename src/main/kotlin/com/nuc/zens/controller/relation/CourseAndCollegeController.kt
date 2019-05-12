package com.nuc.zens.controller.relation

import com.nuc.zens.po.relation.CourseAndCollege
import com.nuc.zens.service.relation.CourseAndCollegeService
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
@RequestMapping("/courseAndCollege")
class CourseAndCollegeController {
    @Autowired
    private lateinit var courseAndCollegeService: CourseAndCollegeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCourseAndCollege(@RequestBody courseAndCollege: CourseAndCollege): Result {
        val msg = courseAndCollegeService.save(courseAndCollege)
        return ResultUtils.success(200, "插入成功", msg)
    }
}