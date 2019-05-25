package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.ClassService
import com.nuc.zens.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author 杨晓辉 2019/5/7 16:17
 */
@RestController
@RequestMapping("/class")
class ClassController {

    @Autowired
    private lateinit var classService: ClassService

    /**
     * 获取所有的班级
     * @return Result
     */
    @GetMapping("/all")
    fun getAllClass(): Result {
        val classes = classService.getAllClasses()
        return ResultUtils.success(data = classes)
    }

    @PostMapping("/add")
    fun addClass(@RequestBody name: String): Result {
        classService.addClass(name)
        return ResultUtils.success(message = "添加成功")
    }

    @GetMapping("/search/{name}")
    fun searchByName(@PathVariable name: String) :Result{
        val list = classService.searchClassName(name)
        return ResultUtils.success(data = list)
    }

}
