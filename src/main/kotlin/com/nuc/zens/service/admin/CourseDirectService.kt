package com.nuc.zens.service.admin

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.admin.CourseDirect

interface CourseDirectService {
    @Throws(ResultException::class)
    fun save(college: CourseDirect)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CourseDirect

    @Throws(ResultException::class)
    fun findAll():List<CourseDirect>
}