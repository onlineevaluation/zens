package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.Knowledge
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

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