package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.ChapterService
import com.nuc.zens.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.Duration
import java.time.LocalTime
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author 杨晓辉 5/2/2019 6:37 PM
 */
@RestController
class ChapterController {


    @Autowired
    private lateinit var chapterService: ChapterService

    /**
     * 获取所有课程
     * @return Result
     */
    @GetMapping("/chapters")
    fun allChapter(): Result {

        val chapters = chapterService.findAllChapter()

        return ResultUtils.success(data = chapters)
    }

    /**
     * 通过课程id获取章节
     * @param courseId ") courseId: Long
     * @return Result
     */
    @GetMapping("/chapter/{courseId}")
    fun chapterById(@PathVariable("courseId") courseId: Long): Result {
        val chapters = chapterService.findChapterByCourseId(courseId)
        return ResultUtils.success(data = chapters)
    }
}