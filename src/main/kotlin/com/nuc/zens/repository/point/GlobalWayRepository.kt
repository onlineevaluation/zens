package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.GlobalWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GlobalWayRepository : JpaRepository<GlobalWay, Long> {
    fun findByCourseIdAndType(courseId: Long, type: String): GlobalWay
}