package com.nuc.zens.controller.tracking

import com.nuc.zens.po.entity.Clazz
import com.nuc.zens.result.Result
import com.nuc.zens.service.ClazzService
import com.nuc.zens.util.ResultUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 课程信息操作
 */

@RestController
@RequestMapping("/clazz")
class ClazzController {
    @Autowired
    private lateinit var clazzService: ClazzService
    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @PostMapping("/insert")
    fun insertClass(@RequestBody clazz: Clazz): Result {
        val msg = clazzService.save(clazz)
        return ResultUtils.success(200, "插入成功", msg)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteOne(@PathVariable id:Long):Result{
        val msg=clazzService.deleteById(id)
        return ResultUtils.success(200,"删除成功",msg)
    }

    @GetMapping("/findOne/{id}")
    fun findOne(@PathVariable id:Long):Result{
        val msg=clazzService.findOne(id)
        return ResultUtils.success(200,"查找成功",msg)
    }

    @GetMapping("/findAll")
    fun findAll():Result{
        val msg=clazzService.findAll()
        return ResultUtils.success(200,"查找成功",msg)
    }

}