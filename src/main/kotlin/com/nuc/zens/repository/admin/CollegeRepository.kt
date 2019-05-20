package com.nuc.zens.repository.admin

import com.nuc.zens.po.admin.College
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollegeRepository: JpaRepository<College, Long> {
}