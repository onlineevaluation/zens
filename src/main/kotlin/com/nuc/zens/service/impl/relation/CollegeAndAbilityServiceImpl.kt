package com.nuc.zens.service.impl.relation

import com.nuc.zens.po.relation.CollegeAndAbility
import com.nuc.zens.repository.relation.CollegeAndAbilityRepository
import com.nuc.zens.service.relation.CollegeAndAbilityService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeAndAbilityServiceImpl : CollegeAndAbilityService {
    override fun getAll(): Map<Long,List<CollegeAndAbility>>? {
        return collegeAndAbilityRepository.findAll().groupBy { it.collegeId }
    }

    override fun saveAll(collegeAndAbilityList: List<CollegeAndAbility>) {
        collegeAndAbilityRepository.saveAll(collegeAndAbilityList)
    }

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var collegeAndAbilityRepository: CollegeAndAbilityRepository

    override fun save(collegeAndAbility: CollegeAndAbility) {
        collegeAndAbilityRepository.save(collegeAndAbility)
    }

    override fun deleteById(id: Long) {
        collegeAndAbilityRepository.deleteById(id)
    }

    override fun findOne(id: Long): CollegeAndAbility {
        return collegeAndAbilityRepository.findById(id).get()
    }
}