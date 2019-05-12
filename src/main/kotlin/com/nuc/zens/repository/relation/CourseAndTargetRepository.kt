package com.nuc.zens.repository.relation

import com.nuc.zens.po.relation.CourseAndTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseAndTargetRepository: JpaRepository<CourseAndTarget, Long> {
}