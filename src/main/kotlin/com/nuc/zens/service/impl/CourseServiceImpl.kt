package com.nuc.zens.service.impl

import com.nuc.zens.po.Course
import com.nuc.zens.repository.CourseRepository
import com.nuc.zens.service.CourseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 5/2/2019 6:14 PM
 */
@Service
class CourseServiceImpl : CourseService {

    @Autowired
    private lateinit var courseRepository: CourseRepository

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