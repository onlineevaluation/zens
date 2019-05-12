package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.DailyWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DailyWayRepository: JpaRepository<DailyWay, Long> {
    fun findDailyWayByCourseIdAndType(id:Long,type:String): DailyWay
}