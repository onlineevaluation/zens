package com.nuc.zens.repository.relation

import com.nuc.zens.po.relation.CourseAndCollege
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourseAndCollegeRepository: JpaRepository<CourseAndCollege, Long> {
    fun findAllByCourseId(id:Long):List<CourseAndCollege>
}