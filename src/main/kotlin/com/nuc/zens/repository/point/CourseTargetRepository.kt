package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.CourseTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseTargetRepository: JpaRepository<CourseTarget, Long> {
    fun findByCourseId(id:Long):List<CourseTarget>?
}