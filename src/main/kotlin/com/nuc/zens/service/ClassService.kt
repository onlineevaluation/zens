package com.nuc.zens.service

import com.nuc.zens.po.Class

/**
 * @author 杨晓辉 2019/5/7 16:20
 */
interface ClassService {


    /**
     * 获取所有的班级
     * @return List<Class>
     */
    fun getAllClasses(): List<Class>
}