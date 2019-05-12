package com.nuc.zens.service.relation

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.relation.KnowledgeAndWay

interface KnowledgeAndWayService {
    @Throws(ResultException::class)
    fun save(knowledgeAndWay: KnowledgeAndWay)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): KnowledgeAndWay
}