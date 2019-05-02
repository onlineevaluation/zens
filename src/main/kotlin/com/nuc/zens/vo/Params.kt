package com.nuc.zens.vo


/**
 * @author 杨晓辉 2018-12-29 16:06
 * 用于接收前端参数的类
 * 所有的类采用data class
 * 所有的后缀采用 **param**
 */

/**
 * 用于接收页面的 `UserParam` 值
 * @param username 用户名
 * @param password 密码
 */
data class UserParam(
    val username: String,
    val password: String
)

/**
 * 接收 Course 的值
 * @property name String
 * @property introduce String
 * @constructor
 */
data class CourseParam(val name:String,val introduce:String)
