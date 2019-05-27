package com.nuc.zens.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.DailyWay

interface DailyWayService {
    @Throws(ResultException::class)
    fun save(dailyWayList: List<DailyWay>)

    @Throws(ResultException::class)
    fun findOne(id: Long): DailyWay

    @Throws(ResultException::class)
    fun findAll(): Map<Long, List<DailyWay>>

    @Throws(ResultException::class)
    fun findDailyWayByCourseIdAndType(id: Long, type: String): DailyWay
}