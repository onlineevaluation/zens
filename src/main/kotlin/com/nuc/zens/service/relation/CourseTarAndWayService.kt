package com.nuc.zens.service.relation

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.relation.CourseTarAndWay

interface CourseTarAndWayService {
    @Throws(ResultException::class)
    fun save(courseTarAndWay: CourseTarAndWay)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseTarAndWay
}