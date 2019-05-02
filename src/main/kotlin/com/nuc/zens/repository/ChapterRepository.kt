package com.nuc.zens.repository

import com.nuc.zens.po.Chapter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2019/4/11 15:35
 */
@Repository
interface ChapterRepository : JpaRepository<Chapter, Long> {

    /**
     * 通过课程id 查找所有相关知识点
     * @param courseId Long
     */
    fun findByCourseId(courseId: Long):List<Chapter>


}