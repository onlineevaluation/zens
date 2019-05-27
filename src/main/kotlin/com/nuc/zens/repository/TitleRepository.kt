package com.nuc.zens.repository

import com.nuc.zens.po.Title
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author 杨晓辉 2019/5/24 15:54
 */
interface TitleRepository : JpaRepository<Title, Long> {


    /**
     * 查找魔种类型的试题
     * @param category String
     * @return List<Title>
     */
    fun findByCategory(category: String): List<Title>
}