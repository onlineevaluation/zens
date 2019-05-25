package com.nuc.zens.repository.admin

import com.nuc.zens.po.admin.CourseDirect
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseDirectRepository: JpaRepository<CourseDirect, Long> {
}