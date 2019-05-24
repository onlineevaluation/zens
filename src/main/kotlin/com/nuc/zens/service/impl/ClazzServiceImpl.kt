package com.nuc.zens.service.impl

import com.nuc.zens.po.entity.Clazz
import com.nuc.zens.repository.ClazzRepository
import com.nuc.zens.service.ClazzService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ClazzServiceImpl : ClazzService {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var clazzRepository: ClazzRepository

    override fun save(clazz: Clazz) {
        clazzRepository.save(clazz)
    }

    override fun findOne(id: Long): Clazz {
        val clazz: Clazz = clazzRepository.findById(id).get()
        return clazz
    }

    override fun findAll(): List<Clazz> {
        val clazzList: List<Clazz> = clazzRepository.findAll()
        return clazzList
    }


    override fun deleteById(id: Long) {
        clazzRepository.deleteById(+id)
    }




}