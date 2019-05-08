package com.nuc.zens.service.impl

import com.nuc.zens.po.Position
import com.nuc.zens.repository.PositionRepository
import com.nuc.zens.service.PositionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 2019/5/8 9:48
 */
@Service
class PositionServiceImpl : PositionService {

    @Autowired
    private lateinit var positionRepository: PositionRepository

    /**
     * 获取所有的职位
     * @return List<Position>
     */
    override fun getPositions(): List<Position> {
        val positions = positionRepository.findAll()
        return positions
    }


}