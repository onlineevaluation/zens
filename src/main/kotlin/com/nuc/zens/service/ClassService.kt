package com.nuc.zens.service

import com.nuc.zens.vo.ClassInfo

/**
 * @author 杨晓辉 2019/5/7 16:20
 */
interface ClassService {


    /**
     * 获取所有的班级
     * @return List<Class>
     */
    fun getAllClasses(): List<ClassInfo>


    /**
     * 添加一个班级
     * @param name String 班级名称
     */
    fun addClass(name: String)

    /**
     * 通过 className 查询班级
     * @param name String
     */
    fun searchClassName(name: String): List<ClassInfo>
}