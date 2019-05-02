package com.nuc.zens.service

import com.nuc.zens.po.Course

/**
 * @author 杨晓辉 5/2/2019 6:13 PM
 */
interface CourseService {

    /**
     * 获取所有课程
     * @return List<Course>
     */
    fun findAllCourses():List<Course>

    /**
     * 添加 course
     * @return Course
     */
    fun saveCourse(name:String,introduce:String):Course
}