package com.nuc.zens.service.impl.admin

import com.nuc.zens.po.entity.Direction
import com.nuc.zens.repository.admin.DirectionRepository
import com.nuc.zens.service.admin.DirectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DirectionServiceImpl:DirectionService {
    @Autowired
    private lateinit var directionRepository:DirectionRepository
    override fun save(direction: Direction) {
        directionRepository.save(direction)
    }

    override fun deleteById(id: Long) {
        directionRepository.deleteById(id)
    }

    override fun findOne(id: Long): Direction {
        return directionRepository.findById(id).get()
    }

    override fun findAll(): Map<Long,List<Direction>> {
        return directionRepository.findAll().groupBy { it.collegeId }
    }
}