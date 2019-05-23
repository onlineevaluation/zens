package com.nuc.zens.service.impl

import com.nuc.zens.po.Role
import com.nuc.zens.repository.RoleRepository
import com.nuc.zens.service.RoleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 2019/5/23 21:30
 */
@Service
class RoleServiceImpl : RoleService {


    @Autowired
    private lateinit var roleRepository: RoleRepository

    /**
     * 获取所有的角色
     * @return List<Role>
     */
    override fun getAllRole(): List<Role> {
        return roleRepository.findAll()
    }


}