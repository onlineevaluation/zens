package com.nuc.zens.service

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.Clazz

interface ClazzService {
    @Throws(ResultException::class)
    fun save(clazz: Clazz)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): Clazz

    @Throws(ResultException::class)
    fun findAll():List<Clazz>

}