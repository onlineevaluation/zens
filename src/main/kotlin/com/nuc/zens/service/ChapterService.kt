package com.nuc.zens.service

import com.nuc.zens.po.Chapter

/**
 * @author 杨晓辉 5/2/2019 6:42 PM
 */
interface ChapterService {

    /**
     * 通过course id 查找 章节
     * @param courseId Long
     * @return List<Chapter>
     */
    fun findChapterByCourseId(courseId:Long):List<Chapter>

    /**
     * 查找所有的章节
     * @return List<Chapter>
     */
    fun findAllChapter():List<Chapter>

}