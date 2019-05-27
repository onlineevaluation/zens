package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface CourseRepository : JpaRepository<Course, Long> {
    fun findCourseByLevel(level: String): List<Course>?
    fun findByCollegeId(collegeId:Long):List<Course>

}