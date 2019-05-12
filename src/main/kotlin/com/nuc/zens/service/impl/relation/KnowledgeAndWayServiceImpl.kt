package com.nuc.zens.service.impl.relation

import com.nuc.zens.po.relation.KnowledgeAndWay
import com.nuc.zens.repository.relation.KnowledgeAndWayRepository
import com.nuc.zens.service.relation.KnowledgeAndWayService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KnowledgeAndWayServiceImpl: KnowledgeAndWayService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var knowledgeAndWayRepository: KnowledgeAndWayRepository

    override fun save(knowledgeAndWay: KnowledgeAndWay) {
        knowledgeAndWayRepository.save(knowledgeAndWay)
    }

    override fun deleteById(id: Long) {
        knowledgeAndWayRepository.deleteById(id)
    }

    override fun findOne(id: Long): KnowledgeAndWay {
       return knowledgeAndWayRepository.findById(id).get()
    }
}