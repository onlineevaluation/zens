package com.nuc.zens.service.impl.point

import com.nuc.zens.po.entity.GlobalWay
import com.nuc.zens.repository.point.GlobalWayRepository
import com.nuc.zens.service.point.GlobalWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class GlobalWayServiceImpl: GlobalWayService {
    override fun saveAll(globalWayList: List<GlobalWay>) {
        globalWayRepository.saveAll(globalWayList)
    }

    override fun findAll(): Map<Long, List<GlobalWay>> {
        return globalWayRepository.findAll().groupBy { it.courseId }
    }

    override fun findOne(id: Long): GlobalWay {
        val globalWay = globalWayRepository.findById(id).get()
        return globalWay
    }

    @Autowired
    private lateinit var globalWayRepository: GlobalWayRepository
    override fun save(globalWay: GlobalWay) {
        globalWayRepository.save(globalWay)
    }
}