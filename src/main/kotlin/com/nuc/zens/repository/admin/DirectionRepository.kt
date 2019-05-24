package com.nuc.zens.repository.admin

import com.nuc.zens.po.entity.Direction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DirectionRepository: JpaRepository<Direction, Long> {
}