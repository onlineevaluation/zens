package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.TeacherService
import com.nuc.zens.util.ResultUtils
import com.nuc.zens.vo.TeacherParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @author 杨晓辉 2019/5/8 10:50
 */
@RestController
class TeacherController {

    @Autowired
    private lateinit var teacherService: TeacherService

    @PostMapping("/teacher")
    fun addTeacher(@RequestBody teacherParam: TeacherParam): Result {
        teacherService.addTeacher(teacherParam.teacherName, teacherParam.teacherNum, teacherParam.positionId)
        return ResultUtils.success()
    }
}