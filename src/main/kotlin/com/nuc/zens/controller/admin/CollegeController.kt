package com.nuc.zens.controller.admin

import com.nuc.zens.po.admin.College
import com.nuc.zens.result.Result
import com.nuc.zens.service.admin.CollegeService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 专业管理
 */

@RestController
@RequestMapping("/college")
class CollegeController {
    @Autowired
    private lateinit var collegeService: CollegeService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertCollege(@RequestBody college: College): Result {
        println("college ${college}")
        val msg = collegeService.save(college)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @GetMapping("/all")
    fun getList(): Result {
        val msg = collegeService.findAll()
        return ResultUtils.success(200, "获取列表", msg)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteOne(@PathVariable id:Long):Result{
        collegeService.deleteById(id)
        val msg=collegeService.findAll()
        return ResultUtils.success(200,"删除成功",msg)
    }

    @GetMapping("/findOne/{id}")
    fun findOne(@PathVariable id:Long):Result{
        val msg=collegeService.findOne(id)
        return ResultUtils.success(200,"查找成功",msg)
    }


}