package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.TitleService
import com.nuc.zens.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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

}