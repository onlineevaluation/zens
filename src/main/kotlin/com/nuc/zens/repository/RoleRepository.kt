package com.nuc.zens.repository

import com.nuc.zens.po.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

/**
 * @author 杨晓辉 2018/2/1 16:37
 */
@Repository
interface RoleRepository : JpaRepository<Role, Long> {

}