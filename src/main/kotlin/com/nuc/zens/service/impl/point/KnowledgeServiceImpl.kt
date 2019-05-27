package com.nuc.zens.service.impl.point

import com.nuc.zens.po.entity.Knowledge
import com.nuc.zens.repository.point.KnowledgeRepository
import com.nuc.zens.service.point.KnowledgeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class KnowledgeServiceImpl : KnowledgeService {
    override fun saveAll(knowledgeList: List<Knowledge>) {
        knowledgeRepository.saveAll(knowledgeList)
    }

    override fun findAll(): Map<Long, List<Knowledge>> {
        return knowledgeRepository.findAll().groupBy { it.courseId }
    }

    override fun findAllByCourseId(courseId: Long): List<Knowledge> {
        return knowledgeRepository.findByCourseId(courseId)
    }

    override fun findOne(id: Long): Knowledge {
        return knowledgeRepository.findById(id).get()
    }

    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository

    override fun save(knowledge: Knowledge) {
        knowledgeRepository.save(knowledge)
    }
}