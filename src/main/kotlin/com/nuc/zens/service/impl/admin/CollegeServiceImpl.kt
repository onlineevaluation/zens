package com.nuc.zens.service.impl.admin

import com.nuc.zens.po.admin.College
import com.nuc.zens.repository.admin.CollegeRepository
import com.nuc.zens.service.admin.CollegeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CollegeServiceImpl : CollegeService {
    @Autowired
    private lateinit var collegeRepository: CollegeRepository

    override fun save(college: College) {
        collegeRepository.save(college)
    }

    override fun deleteById(id: Long) {
        collegeRepository.deleteById(id)
    }

    override fun findOne(id: Long): College {
        return collegeRepository.findById(id).get()
    }

    override fun findAll(): List<College> {
        return collegeRepository.findAll()
    }
}