package com.nuc.zens.repository

import com.nuc.zens.po.Position
import org.springframework.data.jpa.repository.JpaRepository

/**
 * @author 杨晓辉 2019/5/8 8:54
 */
interface PositionRepository : JpaRepository<Position, Long> {

}