package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.util.ResultUtils
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author 杨晓辉 2019/4/26 16:10
 */
@RestController
class IndexController {

    @RequestMapping("/")
    fun index(): Result {
        return ResultUtils.success(data = "hello zens")
    }
}