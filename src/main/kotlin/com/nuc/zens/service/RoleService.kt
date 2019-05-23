package com.nuc.zens.service

import com.nuc.zens.po.Role

/**
 * @author 杨晓辉 2019/5/23 21:29
 */
interface RoleService {

    /**
     * 获取所有的Role
     * @return List<Role>
     */
    fun getAllRole():List<Role>
}