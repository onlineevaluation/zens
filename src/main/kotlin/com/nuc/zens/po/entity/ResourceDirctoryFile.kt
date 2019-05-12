package com.nuc.zens.po.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "uek_resource_dirctory_file")
class ResourceDirctoryFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    var name: String? = null
    var pid: Long = 0
    var addtime: Timestamp? = null
    var url: String? = null
    var type: Long = 0
    var size: String? = null
    var percent: Float = 0f
    var courseId: Long = 0
    var chapterId: Long = 0
    var knowledgeId: Long = 0
    var tq_percent: Float = 0f
    var playTimes: Int = 0

}
