package com.nuc.zens.service.impl.point

import com.nuc.zens.po.entity.DailyWay
import com.nuc.zens.repository.point.DailyWayRepository
import com.nuc.zens.service.point.DailyWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DailyWayServiceImpl: DailyWayService {
    @Autowired
    private lateinit var dailyWayRepository: DailyWayRepository

    override fun save(dailyWayList: List<DailyWay>) {
        dailyWayRepository.saveAll(dailyWayList)
    }

    override fun findAll(): Map<Long, List<DailyWay>> {
        return dailyWayRepository.findAll().groupBy { it.courseId }
    }

    override fun findDailyWayByCourseIdAndType(id: Long,type:String): DailyWay {
        val dailyWay = dailyWayRepository.findDailyWayByCourseIdAndType(id,type)
        return dailyWay
    }

    override fun findOne(id: Long): DailyWay {
        val dailyWay = dailyWayRepository.findById(id).get()
        return dailyWay
    }

}