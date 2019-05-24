package com.nuc.zens.service

import com.nuc.zens.vo.TitleInfo

/**
 * @author 杨晓辉 2019/5/24 15:36
 */
interface TitleService {

    fun getAllTitle(): List<TitleInfo>
}