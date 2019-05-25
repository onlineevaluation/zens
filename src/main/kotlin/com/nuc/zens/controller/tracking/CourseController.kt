package com.nuc.zens.controller.tracking

import com.nuc.zens.po.admin.CourseResponse
import com.nuc.zens.po.entity.Course
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
import com.nuc.zens.service.point.CourseService
import com.nuc.zens.util.ResultUtils
import com.nuc.zens.vo.CourseParam
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 课程信息操作
 */

@RestController
@RequestMapping("/course")
class CourseController {
    @Autowired
    private lateinit var courseService: CourseService
    @Autowired
    private lateinit var collegeService: CollegeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertClass(@RequestBody course: Course): Result {
        val msg = courseService.save(course)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteOne(@PathVariable id: Long): Result {
        val msg = courseService.deleteById(id)
        return ResultUtils.success(200, "删除成功", msg)
    }

    @GetMapping("/findOne/{id}")
    fun findOne(@PathVariable id: Long): Result {
        val msg = courseService.findOne(id)
        return ResultUtils.success(200, "查找成功", msg)
    }

    @GetMapping("/findAll")
    fun findAll(): Result {
        val msg = courseService.findAll()
        return ResultUtils.success(200, "查找成功", msg)
    }

    @GetMapping("/findAllGroupByCollege")
    fun findAllGroupByCollege(): Result {
        val temp = courseService.findAllGroupByCollege()
        val msg = temp.map { (key, value) ->
            var courseResponse = CourseResponse()
            courseResponse.collegeName = collegeService.findOne(key).major!!
            courseResponse.courseList = value
            return@map courseResponse
        }
        return ResultUtils.success(200, "查找成功", msg)
    }

    @GetMapping("/findByLevel/{level}")
    fun findByLevel(@PathVariable level: String): Result {
        val msg = courseService.findByLevel(level)
        return ResultUtils.success(200, "查找成功", msg)
    }

    /**
     * @author 杨晓辉 5/2/2019 6:07 PM
     */

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
        courseService.saveCourse(courseParam.name, courseParam.introduce)
        return ResultUtils.success()
    }

}