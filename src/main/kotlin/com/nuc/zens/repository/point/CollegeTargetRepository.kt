package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.CollegeTarget
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollegeTargetRepository: JpaRepository<CollegeTarget, Long> {

}