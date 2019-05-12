package com.nuc.zens.service.impl.point


import com.nuc.zens.po.entity.CourseTarget
import com.nuc.zens.repository.point.CourseTargetRepository
import com.nuc.zens.service.point.CourseTargetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseTargetServiceImpl: CourseTargetService {
    override fun findByCourseId(id: Long): CourseTarget {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findOne(id: Long): CourseTarget {
        val courseTarget = courseTargetRepository.findById(id).get()
        return courseTarget
    }

    @Autowired
    private lateinit var courseTargetRepository: CourseTargetRepository
    override fun save(courseTarget: CourseTarget) {
        courseTargetRepository.save(courseTarget)
    }
}