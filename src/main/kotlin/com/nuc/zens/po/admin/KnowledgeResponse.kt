package com.nuc.zens.po.admin

import com.nuc.zens.po.entity.Knowledge

class KnowledgeResponse {
    var courseName: String = ""
    lateinit var knowledgeList: List<Knowledge>
}