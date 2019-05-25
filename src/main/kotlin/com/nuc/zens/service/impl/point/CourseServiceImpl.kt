package com.nuc.zens.service.impl.point

import com.nuc.zens.po.entity.Course
import com.nuc.zens.repository.point.CourseRepository
import com.nuc.zens.service.point.CourseService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 * @author 曹华珠 5/2/2019 6:14 PM
 */
@Service
class CourseServiceImpl : CourseService {
    override fun findAllGroupByCollege(): Map<Long,List<Course>> {
        return courseRepository.findAll().groupBy { it.collegeId }
    }

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var courseRepository: CourseRepository

    override fun findByLevel(level: String): List<Course> {
        val courseList: List<Course> = courseRepository.findCourseByLevel(level)!!
        return courseList

    }

    override fun findAll(): List<Course> {
        val courseList: List<Course> = courseRepository.findAll()
        return courseList
    }

    override fun findOne(id: Long): Course {
        return courseRepository.findById(id).get()

    }

    override fun deleteById(id: Long) {
        courseRepository.deleteById(+id)
    }


    override fun save(course: Course) {
        courseRepository.save(course)
    }


    /**
     * @author 杨晓辉 5/2/2019 6:14 PM
     */
    /**
     * 获取所有的课程
     * @return List<Course>
     */
    override fun findAllCourses(): List<Course> {
        return courseRepository.findAll()
    }

    /**
     * 添加课程
     * @param name String
     * @param introduce String
     * @return Course
     */
    override fun saveCourse(name: String, introduce: String): Course {
        val course = courseRepository.save(
                Course().apply {
                    this.name = name
                    this.introduce = introduce
                }
        )
        return course
    }
}