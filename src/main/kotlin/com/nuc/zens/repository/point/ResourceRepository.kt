package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.ResourceDirctoryFile
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceRepository : JpaRepository<ResourceDirctoryFile, Long> {
}