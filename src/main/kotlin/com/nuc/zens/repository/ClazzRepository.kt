package com.nuc.zens.repository

import com.nuc.zens.po.entity.Clazz
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ClazzRepository : JpaRepository<Clazz, Long> {
    fun findByNum(num: String): Clazz
}