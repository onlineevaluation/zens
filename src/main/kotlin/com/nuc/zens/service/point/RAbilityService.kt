package com.nuc.zens.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.RAbility

interface RAbilityService {

    @Throws(ResultException::class)
    fun save(ability: RAbility)
    @Throws(ResultException::class)
    fun findOne(id: Long): RAbility

    @Throws(ResultException::class)
    fun getAll(id: Long): List<RAbility>
}