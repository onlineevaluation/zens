package com.nuc.zens.service.impl.point

import com.nuc.zens.po.entity.ResourceDirctoryFile
import com.nuc.zens.repository.point.ResourceRepository
import com.nuc.zens.service.point.ResourceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ResourceServiceImpl: ResourceService {
    override fun findOne(id: Long): ResourceDirctoryFile {
        return resourceRepository.findById(id).get()
    }

    @Autowired
    private lateinit var resourceRepository: ResourceRepository
    override fun save(resource: ResourceDirctoryFile) {
        resourceRepository.save(resource)
    }
}