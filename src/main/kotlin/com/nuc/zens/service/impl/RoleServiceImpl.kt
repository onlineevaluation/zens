package com.nuc.zens.service.impl

import com.nuc.zens.po.Role
import com.nuc.zens.po.UserAndRole
import com.nuc.zens.repository.RoleRepository
import com.nuc.zens.repository.TeacherRepository
import com.nuc.zens.repository.UserAndRoleRepository
import com.nuc.zens.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author 杨晓辉 2019/5/23 21:30
 */
@Service
@Transactional
class RoleServiceImpl : RoleService {


    @Autowired
    private lateinit var roleRepository: RoleRepository

    @Autowired
    private lateinit var userAndRoleRepository: UserAndRoleRepository

    @Autowired
    private lateinit var teacherRepository: TeacherRepository

    /**
     * 获取所有的角色
     * @return List<Role>
     */
    override fun getAllRole(): List<Role> {
        return roleRepository.findAll()
    }


    /**
     * 更新权限
     * @param teacherId Long
     * @param roles Array<Int>
     */
    @Transactional
    override fun updateRole(teacherId: Long, roles: Array<Int>) {
        val teacher = teacherRepository.findById(teacherId).get()
        println("teacher = ${teacher.id}")
        userAndRoleRepository.deleteByUserId(teacher.userId)
        val list = roles.map {
            UserAndRole().apply {
                this.userId = teacher.userId
                this.roleId = it.toLong()
            }
        }

        println("list = ${list}")

        userAndRoleRepository.saveAll(list)
    }
}