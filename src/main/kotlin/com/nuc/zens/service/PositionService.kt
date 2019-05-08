package com.nuc.zens.service

import com.nuc.zens.po.Position

/**
 * @author 杨晓辉 2019/5/8 9:48
 */
interface PositionService {

    /**
     * 获得全部职位信息
     * @return List<Position>
     */
    fun getPositions(): List<Position>


}