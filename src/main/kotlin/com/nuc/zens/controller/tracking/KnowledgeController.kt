package com.nuc.zens.controller.tracking

import com.nuc.zens.po.entity.Knowledge
import com.nuc.zens.result.Result
import com.nuc.zens.service.point.KnowledgeService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 知识点的操作
 */

@RestController
@RequestMapping("/knowledge")
class KnowledgeController {
    @Autowired
    private lateinit var knowledgeService: KnowledgeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertKnowledge(@RequestBody knowledge: Knowledge): Result {
        val msg = knowledgeService.save(knowledge)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/findByCourse")
    fun findByCourse(courseId: Long): Result {
        val msg = knowledgeService.findAllByCourseId(courseId)
        return ResultUtils.success(200, "查找成功", msg)
    }
}