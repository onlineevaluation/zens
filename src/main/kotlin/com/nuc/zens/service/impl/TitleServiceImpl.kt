package com.nuc.zens.service.impl

import com.nuc.zens.po.Title
import com.nuc.zens.repository.TitleRepository
import com.nuc.zens.repository.point.CourseRepository
import com.nuc.zens.repository.point.KnowledgeRepository
import com.nuc.zens.service.TitleService
import com.nuc.zens.vo.TitleInfo
import com.nuc.zens.vo.TitleParam
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author 杨晓辉 2019/5/24 15:36
 */
@Service
@Transactional
class TitleServiceImpl : TitleService {

    @Autowired
    private lateinit var titleRepository: TitleRepository

    @Autowired
    private lateinit var courseRepository: CourseRepository


    @Autowired
    private lateinit var knowledgeRepository: KnowledgeRepository

    /**
     * 获取所有的试题
     * @return List<TitleInfo>
     */
    override fun getAllTitle(): List<TitleInfo> {
        val titles = titleRepository.findAll()
        return titles.map {
            val titleInfo = TitleInfo()
            BeanUtils.copyProperties(it, titleInfo)
            titleInfo.category = when (it.category) {
                "1" -> {
                    "选择题"
                }
                "2" -> {
                    "填空题"
                }
                "3" -> {
                    "简单题"
                }
                "4" -> {
                    "代码题"
                }
                "5" -> {
                    "算法题"
                }
                else -> {
                    "未知"
                }
            }
            val knowledge = knowledgeRepository.findById(it.knowledgeId).get()
            titleInfo.knowledge = knowledge.name
            titleInfo.course = courseRepository.findById(it.courseId).get().name
            if (it.orderd) {
                titleInfo.orderd = 1
            } else {
                titleInfo.orderd = 0
            }
            return@map titleInfo
        }

    }


    /**
     * 添加完成的试题
     * @param titleParam TitleParam
     */
    override fun addTitle(titleParam: TitleParam) {
        val title = Title()
        BeanUtils.copyProperties(titleParam, title)
        println("title = ${title}")
        titleRepository.saveAndFlush(title)
    }

    override fun updateTitle(titleParam: TitleParam) {


    }

    override fun findTitleByCategory(category: String): List<TitleInfo> {
        val titleList = titleRepository.findByCategory(category)
        return titleList.filter { it.category == "5" }.map {
            val titleInfo = TitleInfo()
            BeanUtils.copyProperties(it, titleInfo)
            return@map titleInfo
        }

    }
}