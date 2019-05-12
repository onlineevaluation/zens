package com.nuc.zens.service.impl.point

import com.nuc.zens.po.entity.DailyWay
import com.nuc.zens.repository.point.DailyWayRepository
import com.nuc.zens.service.point.DailyWayService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DailyWayServiceImpl: DailyWayService {
    override fun findDailyWayByCourseIdAndType(id: Long,type:String): DailyWay {
        val dailyWay = dailyWayRepository.findDailyWayByCourseIdAndType(id,type)
        return dailyWay
    }

    override fun findOne(id: Long): DailyWay {
        val dailyWay = dailyWayRepository.findById(id).get()
        return dailyWay
    }

    @Autowired
    private lateinit var dailyWayRepository: DailyWayRepository
    override fun save(dailyWay: DailyWay) {
        dailyWayRepository.save(dailyWay)
    }
}