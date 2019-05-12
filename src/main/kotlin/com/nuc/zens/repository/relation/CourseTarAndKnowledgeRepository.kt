package com.nuc.zens.repository.relation

import com.nuc.zens.po.relation.CourseTarAndKnowledge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseTarAndKnowledgeRepository: JpaRepository<CourseTarAndKnowledge, Long> {
    fun findAllByCourseId(id:Long):List<CourseTarAndKnowledge>
}