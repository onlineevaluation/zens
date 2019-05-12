package com.nuc.zens.service.point

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.entity.ResourceDirctoryFile

interface ResourceService {
    @Throws(ResultException::class)
    fun save(resource: ResourceDirctoryFile)
    @Throws(ResultException::class)
    fun findOne(id: Long): ResourceDirctoryFile
}