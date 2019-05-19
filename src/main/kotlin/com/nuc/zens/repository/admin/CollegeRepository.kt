package com.nuc.tracking.teacherend.repository.admin

import com.nuc.tracking.teacherend.po.admin.College
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CollegeRepository: JpaRepository<College, Long> {
}