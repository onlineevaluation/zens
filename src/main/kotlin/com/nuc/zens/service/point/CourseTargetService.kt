package com.nuc.zens.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.CourseTarget

interface CourseTargetService {
    @Throws(ResultException::class)
    fun save(courseTarget: CourseTarget)

    @Throws(ResultException::class)
    fun findOne(id: Long): CourseTarget

    @Throws(ResultException::class)
    fun findByCourseId(id: Long): CourseTarget
}