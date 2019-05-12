package com.nuc.zens.repository.point

import com.nuc.zens.po.entity.ResourceLog
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResourceLogRepository : JpaRepository<ResourceLog, Long> {
}