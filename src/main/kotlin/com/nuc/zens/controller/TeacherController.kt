package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.TeacherService
import com.nuc.zens.util.ResultUtils
import com.nuc.zens.vo.TeacherParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author 杨晓辉 2019/5/8 10:50
 */
@RestController
class TeacherController {

    @Autowired
    private lateinit var teacherService: TeacherService

    /**
     * 添加教师
     * @param teacherParam TeacherParam
     * @return Result
     */
    @PostMapping("/teacher")
    fun addTeacher(@RequestBody teacherParam: TeacherParam): Result {
        teacherService.addTeacher(
            teacherParam.teacherName,
            teacherParam.teacherNum,
            teacherParam.positionId,
            teacherParam.sex
        )
        return ResultUtils.success()
    }

    /**
     * 更新教师内容
     * @param teacherParam TeacherParam
     * @return Result
     */
    @PutMapping("/teacher/{teacherId}")
    fun updateTeacher(@RequestBody teacherParam: TeacherParam, @PathVariable("teacherId") teacherId: Long): Result {
        println("teacherParam = $teacherParam")
        teacherService.updateTeacher(
            teacherId,
            teacherParam.teacherName,
            teacherParam.teacherNum,
            teacherParam.positionId,
            teacherParam.sex
        )
        return ResultUtils.success()
    }


    /**
     * 查找教师和相关权限
     * @return Result
     */
    @GetMapping("/teacher/role")
    fun getAllTeacherRole(): Result {
        val teacherList = teacherService.findAllTeacherRole()
        return ResultUtils.success(data = teacherList)
    }
}