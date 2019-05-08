package com.nuc.zens.service.impl

import com.nuc.zens.po.Class
import com.nuc.zens.repository.ClassRepository
import com.nuc.zens.service.ClassService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 2019/5/7 16:21
 */
@Service
class ClassServiceImpl : ClassService {


    @Autowired
    private lateinit var classRepository: ClassRepository

    override fun getAllClasses(): List<Class> {
        return classRepository.findAll()
    }
}