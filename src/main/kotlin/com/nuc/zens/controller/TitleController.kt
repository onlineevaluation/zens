package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.TitleService
import com.nuc.zens.util.ResultUtils
import com.nuc.zens.vo.TitleParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author 杨晓辉 5/2/2019 6:05 PM
 */
@RestController
class TitleController {

    @Autowired
    private lateinit var titleService: TitleService

    /**
     * 获取所有的试题
     * @return Result
     */
    @GetMapping("/titles")
    fun getAllTitle(): Result {
        val list = titleService.getAllTitle()
        return ResultUtils.success(data = list)
    }

    @PostMapping("/title")
    fun addTitle(@RequestBody titleParam: TitleParam): Result {

        return ResultUtils.success()
    }

    @PutMapping("/title")
    fun updateTitle(@RequestBody titleParam: TitleParam): Result {
        return ResultUtils.success()
    }

    @GetMapping("/title/{category}")
    fun getCategory(@PathVariable category: String): Result {
        val list = titleService.findTitleByCategory(category)
        return ResultUtils.success(data = list)
    }
}