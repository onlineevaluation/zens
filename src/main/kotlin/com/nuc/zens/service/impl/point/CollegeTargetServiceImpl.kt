package com.nuc.zens.service.impl.point

import com.nuc.zens.po.entity.CollegeTarget
import com.nuc.zens.repository.point.CollegeTargetRepository
import com.nuc.zens.service.point.CollegeTargetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeTargetServiceImpl: CollegeTargetService {
    override fun findOne(id: Long): CollegeTarget {
        val collegeTarget = collegeTargetRepository.findById(id).get()
        return collegeTarget
    }

    @Autowired
    private lateinit var collegeTargetRepository: CollegeTargetRepository
    override fun save(collegeTarget: CollegeTarget) {
        collegeTargetRepository.save(collegeTarget)
    }
}
