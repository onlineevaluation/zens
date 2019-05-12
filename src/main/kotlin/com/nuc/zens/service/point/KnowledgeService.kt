package com.nuc.zens.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.Knowledge

interface KnowledgeService {
    @Throws(ResultException::class)
    fun save(knowledge: Knowledge)

    @Throws(ResultException::class)
    fun findOne(id: Long): Knowledge

    @Throws(ResultException::class)
    fun findAllByCourseId(courseId: Long): List<Knowledge>
}