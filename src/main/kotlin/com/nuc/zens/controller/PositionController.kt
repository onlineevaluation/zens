package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.PositionService
import com.nuc.zens.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author 杨晓辉 2019/5/8 9:41
 */
@RestController
class PositionController {

    @Autowired
    private lateinit var postionService: PositionService

    /**
     * 获取所有的职位信息
     * @return Result
     */
    @GetMapping("/positions")
    fun getAllPosition(): Result {
        val positions = postionService.getPositions()
        return ResultUtils.success(data = positions)
    }

}