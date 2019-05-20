package com.nuc.zens.service.admin

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.admin.College

interface CollegeService {
    @Throws(ResultException::class)
    fun save(college: College)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): College

    @Throws(ResultException::class)
    fun findAll():List<College>
}