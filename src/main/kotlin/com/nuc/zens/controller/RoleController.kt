package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.RoleService
import com.nuc.zens.util.ResultUtils
import com.nuc.zens.vo.TeacherRoleParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * @author 杨晓辉 2019/5/23 21:28
 */
@RestController
class RoleController {

    @Autowired
    private lateinit var roleService: RoleService

    /**
     * 获取所有的权限
     * @return Result
     */
    @GetMapping("/roles")
    fun getAllRole(): Result {
        val roles = roleService.getAllRole()
        return ResultUtils.success(data = roles)
    }


    @PutMapping("/role")
    fun updateTeacherRole(@RequestBody teacherRoleParam: TeacherRoleParam):Result {
        roleService.updateRole(teacherRoleParam.teacherId, teacherRoleParam.roleIds)
        return ResultUtils.success()
    }

}