package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.CourseService
import com.nuc.zens.util.ResultUtils
import com.nuc.zens.vo.CourseParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author 杨晓辉 5/2/2019 6:07 PM
 */
@RestController
@RequestMapping("/course")
class CourseController {

    @Autowired
    private lateinit var courseService: CourseService

    /**
     * 获取所有课程
     * @return Result
     */
    @GetMapping("/courses")
    fun allCourses(): Result {
        val courses = courseService.findAllCourses()
        return ResultUtils.success(data = courses)
    }

    /**
     * 添加课程
     * @param courseParam CourseParam
     * @return Result
     */
    @PostMapping("/course")
    fun addCourse(courseParam: CourseParam): Result {
        courseService.saveCourse(courseParam.name,courseParam.introduce)
        return ResultUtils.success()
    }

    /**
     * 根据id删除课程
     * @param courseId ") courseId:Long
     */
    @DeleteMapping("/c/{courseId}")
    fun deleteCourse(@PathVariable("courseId") courseId:Long) {

    }
}