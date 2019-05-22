package com.nuc.zens.result

/**
 * @author 杨晓辉 2019/4/26 15:57
 */
class Result {
    var data: Any? = null

    var code: Int = 200

    var message: String = "请求成功"


    override fun toString(): String {
        return "Result(data=$data, code=$code, message='$message')"
    }


}