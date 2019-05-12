package com.nuc.zens.service.impl.relation

import com.nuc.zens.po.relation.CourseTarAndWay
import com.nuc.zens.repository.relation.CourseTarAndWayRepository
import com.nuc.zens.service.relation.CourseTarAndWayService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CourseTarAndWayServiceImpl: CourseTarAndWayService {
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var courseTarAndWayReposcitory: CourseTarAndWayRepository

    override fun save(courseTarAndWay: CourseTarAndWay) {
        courseTarAndWayReposcitory.save(courseTarAndWay)
    }

    override fun deleteById(id: Long) {
        courseTarAndWayReposcitory.deleteById(id)
    }

    override fun findOne(id: Long): CourseTarAndWay {
        return courseTarAndWayReposcitory.findById(id).get()
    }
}