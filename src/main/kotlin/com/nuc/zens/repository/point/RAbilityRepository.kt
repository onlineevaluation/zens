package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.RAbility
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RAbilityRepository : JpaRepository<RAbility, Long> {
    fun findByCollegeId(collegeId: Long): List<RAbility>?
}