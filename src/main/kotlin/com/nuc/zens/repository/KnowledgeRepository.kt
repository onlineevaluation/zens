package com.nuc.zens.repository

import com.nuc.zens.po.Knowledge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2019/4/11 15:54
 */
@Repository
interface KnowledgeRepository : JpaRepository<Knowledge, Long> {

    /**
     * 通过章节id查找知识点
     * @param chapterId Long 章节id
     * @return List<Knowledge>
     */
    fun findByChapterId(chapterId: Long): List<Knowledge>

    /**
     * 通过课程查找知识点
     */
    fun findByCourseId(courseId: Long): List<Knowledge>
}