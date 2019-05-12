package com.nuc.zens.service.impl.point

import com.nuc.zens.repository.point.RAbilityRepository
import com.nuc.tracking.teacherend.service.point.RAbilityService
import com.nuc.zens.po.entity.RAbility
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class RAbilityServiceImpl:RAbilityService {
    override fun findOne(id: Long): RAbility {
        val rAbility = rAbilityRepository.findById(id).get()
        return rAbility
    }

    @Autowired
    private lateinit var rAbilityRepository: RAbilityRepository
    override fun save(rAbility: RAbility) {
        rAbilityRepository.save(rAbility)
    }
}