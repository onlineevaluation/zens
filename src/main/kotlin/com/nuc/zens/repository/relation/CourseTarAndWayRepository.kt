package com.nuc.zens.repository.relation

import com.nuc.zens.po.relation.CourseTarAndWay
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseTarAndWayRepository: JpaRepository<CourseTarAndWay, Long> {
}