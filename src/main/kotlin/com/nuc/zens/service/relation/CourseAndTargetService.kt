package com.nuc.zens.service.relation

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.relation.CourseAndTarget

interface CourseAndTargetService {
    @Throws(ResultException::class)
    fun save(courseAndTarget: CourseAndTarget)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseAndTarget

}