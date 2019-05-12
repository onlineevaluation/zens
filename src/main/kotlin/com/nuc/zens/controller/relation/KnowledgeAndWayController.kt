package com.nuc.zens.controller.relation

import com.nuc.zens.po.relation.KnowledgeAndWay
import com.nuc.zens.service.relation.KnowledgeAndWayService
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
@RequestMapping("/knowledgeAndWay")
class KnowledgeAndWayController {
    @Autowired
    private lateinit var knowledgeAndWayService: KnowledgeAndWayService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertKnowledgeAndWay(@RequestBody knowledgeAndWay: KnowledgeAndWay): Result {
        val msg = knowledgeAndWayService.save(knowledgeAndWay)
        return ResultUtils.success(200, "插入成功", msg)
    }
}