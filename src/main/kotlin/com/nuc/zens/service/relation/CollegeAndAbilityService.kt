package com.nuc.zens.service.relation

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.relation.CollegeAndAbility

interface CollegeAndAbilityService {
    @Throws(ResultException::class)
    fun save(collegeAndAbility: CollegeAndAbility)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id:Long): CollegeAndAbility
}