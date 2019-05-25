package com.nuc.zens.service.impl.admin

import com.nuc.zens.po.admin.CourseDirect
import com.nuc.zens.repository.admin.CourseDirectRepository
import com.nuc.zens.service.admin.CourseDirectService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseDirectServiceImpl:CourseDirectService {
    @Autowired
    private lateinit var courseDirectRepository: CourseDirectRepository
    override fun save(courseDirect: CourseDirect) {
        courseDirectRepository.save(courseDirect)
    }

    override fun deleteById(id: Long) {
        courseDirectRepository.deleteById(id)
    }

    override fun findOne(id: Long): CourseDirect {
        return courseDirectRepository.findById(id).get()
    }

    override fun findAll(): List<CourseDirect> {
        return courseDirectRepository.findAll()
    }
}