package com.nuc.zens.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.GlobalWay

interface GlobalWayService {
    @Throws(ResultException::class)
    fun save(globalWay: GlobalWay)

    @Throws(ResultException::class)
    fun saveAll(globalWayList: List<GlobalWay>)

    @Throws(ResultException::class)
    fun findOne(id: Long): GlobalWay

    @Throws(ResultException::class)
    fun findAll(): Map<Long,List<GlobalWay>>
}