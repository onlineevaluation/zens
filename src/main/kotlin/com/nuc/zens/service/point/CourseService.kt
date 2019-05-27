package com.nuc.zens.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.Course

/**
 * @author 曹华珠 5/2/2019 6:13 PM
 */

interface CourseService {
    @Throws(ResultException::class)
    fun save(course: Course)

    @Throws(ResultException::class)
    fun deleteById(id: Long)

    @Throws(ResultException::class)
    fun findOne(id: Long): Course

    @Throws(ResultException::class)
    fun findAll(): List<Course>

    @Throws(ResultException::class)
    fun findAllGroupByCollege(): Map<Long,List<Course>>

    @Throws(ResultException::class)
    fun findByLevel(level: String): List<Course>

    @Throws(ResultException::class)
    fun findByCollegeId(collegeId: Long): List<Course>
    /**
     * @author 杨晓辉 5/2/2019 6:13 PM
     */
    /**
     * 获取所有课程
     * @return List<Course>
     */
    fun findAllCourses(): List<Course>

    /**
     * 添加 course
     * @return Course
     */
    fun saveCourse(name: String, introduce: String): Course
}