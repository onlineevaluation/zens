package com.nuc.zens.repository.relation

import com.nuc.zens.po.relation.KnowledgeAndWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface KnowledgeAndWayRepository : JpaRepository<KnowledgeAndWay, Long> {
}