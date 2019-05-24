package com.nuc.zens.repository

import com.nuc.zens.po.Title
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author 杨晓辉 2019/5/24 15:54
 */
interface TitleRepository : JpaRepository<Title, Long> {
}