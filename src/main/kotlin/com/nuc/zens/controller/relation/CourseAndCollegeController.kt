package com.nuc.zens.controller.relation

import com.nuc.zens.po.admin.CouAndCollResponse
import com.nuc.zens.po.admin.CourseAndCollegeResponse
import com.nuc.zens.po.relation.CourseAndCollege
import com.nuc.zens.service.relation.CourseAndCollegeService
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
import com.nuc.zens.service.point.CollegeTargetService
import com.nuc.zens.service.point.CourseService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Suppress("LABEL_NAME_CLASH")
@RestController
@RequestMapping("/courseAndCollege")
class CourseAndCollegeController {
    @Autowired
    private lateinit var courseAndCollegeService: CourseAndCollegeService
    @Autowired
    private lateinit var courseService: CourseService
    @Autowired
    private lateinit var collegeTargetService: CollegeTargetService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCourseAndCollege(@RequestBody courseAndCollege: CourseAndCollege): Result {
        val msg = courseAndCollegeService.save(courseAndCollege)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/getAll")
    fun getAll(): Result {
        val msg = ArrayList<CourseAndCollegeResponse>()
        var courseAndCollegeList = courseAndCollegeService.findAll()
        if (courseAndCollegeList !== null) {

            courseAndCollegeList.map { (key, value) ->
                val courseAndCollegeResponse=CourseAndCollegeResponse()
                courseAndCollegeResponse.courseName=courseService.findOne(key).name
                courseAndCollegeResponse.relationList=value.map { item ->
                    val couAndCollResponse = CouAndCollResponse()
                    couAndCollResponse.id = item.id
                    couAndCollResponse.collegeId = item.collegeId
                    couAndCollResponse.collegeTargetId = item.collegeTargetId
                    couAndCollResponse.collegeTargetName = collegeTargetService.findOne(item.collegeTargetId).name
                    couAndCollResponse.courseId = item.courseId
                    couAndCollResponse.courseName = courseService.findOne(item.courseId).name
                    couAndCollResponse.percent = item.percent
                    return@map couAndCollResponse
                }
                msg.add(courseAndCollegeResponse)
            }
        }

        return ResultUtils.success(200, "查找课程和专标关系成功", msg)
    }
}