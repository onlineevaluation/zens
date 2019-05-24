package com.nuc.zens.service.admin

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.Direction

interface DirectionService {
    @Throws(ResultException::class)
    fun save(direction: Direction)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): Direction

    @Throws(ResultException::class)
    fun findAll():Map<Long,List<Direction>>
}