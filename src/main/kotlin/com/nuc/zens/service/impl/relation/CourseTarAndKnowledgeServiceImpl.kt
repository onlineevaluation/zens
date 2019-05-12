package com.nuc.zens.service.impl.relation

import com.nuc.zens.po.relation.CourseTarAndKnowledge
import com.nuc.zens.repository.relation.CourseTarAndKnowledgeRepository
import com.nuc.zens.service.relation.CourseTarAndKnowledgeService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseTarAndKnowledgeServiceImpl: CourseTarAndKnowledgeService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var courseTarAndKnowledgeRepository: CourseTarAndKnowledgeRepository

    override fun save(courseTarAndKnowledge: CourseTarAndKnowledge) {
        courseTarAndKnowledgeRepository.save(courseTarAndKnowledge)
    }

    override fun deleteById(id: Long) {
        courseTarAndKnowledgeRepository.deleteById(id)
    }

    override fun findOne(id: Long): CourseTarAndKnowledge {
        return courseTarAndKnowledgeRepository.findById(id).get()
    }
}