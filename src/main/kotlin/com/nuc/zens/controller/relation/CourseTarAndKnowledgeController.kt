package com.nuc.zens.controller.relation

import com.nuc.zens.po.admin.CouTAndKnowResponse
import com.nuc.zens.po.admin.CourseTarAndKnowledgeResponse
import com.nuc.zens.po.relation.CourseTarAndKnowledge
import com.nuc.zens.service.relation.CourseTarAndKnowledgeService
import com.nuc.zens.result.Result
import com.nuc.zens.service.point.CourseService
import com.nuc.zens.service.point.CourseTargetService
import com.nuc.zens.service.point.KnowledgeService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Suppress("LABEL_NAME_CLASH")
@RestController
@RequestMapping("/courseTarAndKnowledge")
class CourseTarAndKnowledgeController {
    @Autowired
    private lateinit var courseTarAndKnowledgeService: CourseTarAndKnowledgeService

    @Autowired
    private lateinit var courseService: CourseService

    @Autowired
    private lateinit var knowledgeService:KnowledgeService

    @Autowired
    private lateinit var courseTargetService: CourseTargetService

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCourseTarAndKnowledge(@RequestBody courseTarAndKnowledge: CourseTarAndKnowledge): Result {
        val msg = courseTarAndKnowledgeService.save(courseTarAndKnowledge)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/getAll")
    fun getAll(): Result {
        val temp = courseTarAndKnowledgeService.findAll()
        val msg = temp.map { (key, value) ->
            val courseTarAndKnowledgeResponse = CourseTarAndKnowledgeResponse()
            courseTarAndKnowledgeResponse.courseName = courseService.findOne(key).name
            courseTarAndKnowledgeResponse.couTAndKnowResponseList = value.map { item ->
                val couTAndKnowResponse = CouTAndKnowResponse()
                println("知识点id ${item.knowledgeId}")
                couTAndKnowResponse.knowledgeName=knowledgeService.findOne(item.knowledgeId).name!!
                couTAndKnowResponse.courseTargetName=courseTargetService.findOne(item.courseTargetId).name
                couTAndKnowResponse.courseTargetAndKnowledge=item
                return@map couTAndKnowResponse
            }
            return@map courseTarAndKnowledgeResponse
        }

        return ResultUtils.success(200, "插入成功", msg)
    }
}