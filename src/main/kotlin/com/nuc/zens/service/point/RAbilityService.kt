package com.nuc.tracking.teacherend.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.RAbility

interface RAbilityService {

    @Throws(ResultException::class)
    fun save(ability: RAbility)
    @Throws(ResultException::class)
    fun findOne(id: Long): RAbility
}