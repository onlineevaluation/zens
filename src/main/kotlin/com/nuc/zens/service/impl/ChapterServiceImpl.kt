package com.nuc.zens.service.impl

import com.nuc.zens.po.Chapter
import com.nuc.zens.repository.ChapterRepository
import com.nuc.zens.service.ChapterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 5/2/2019 6:43 PM
 */
@Service
class ChapterServiceImpl : ChapterService {

    @Autowired
    private lateinit var chapterRepository: ChapterRepository

    /**
     * 通过 课程 id 查找章节
     * @param courseId Long
     * @return List<Chapter>
     */
    override fun findChapterByCourseId(courseId: Long): List<Chapter> {
        val chapters = chapterRepository.findByCourseId(courseId)

        return chapters
    }

    /**
     * 查找所有的课程
     * @return List<Chapter>
     */
    override fun findAllChapter(): List<Chapter> {
        return chapterRepository.findAll()
    }
}