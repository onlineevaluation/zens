package com.nuc.zens.repository

import com.nuc.zens.po.Class
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2019/4/3 18:17
 */
@Repository
interface ClassRepository : JpaRepository<Class, Long> {

    /**
     * 通过名字查询班级
     * @param name String
     */
    fun findByNameLike(name: String):List<Class>
}