package com.nuc.zens.service

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File

/**
 * @author 杨晓辉 4/27/2019 7:46 PM
 */
@Service
interface FileService {
    /**
     * 文件上传
     * @param file MultipartFile
     * @param type String 上传类型
     */
    fun uploadExcelFile(file: MultipartFile, type: String)

    /**
     * 创建添加学生模板
     * @return File
     */
    fun createTemplateOfStudent(): File

    /**
     * 创建添加试题模板
     * @param courseId Long
     * @return File
     */
    fun createTemplateOfTitle(courseId: Long): File

    /**
     * 创建添加章节模板
     * @return File
     */
    fun createTemplateOfChapter(): File

    /**
     * 创建添加课程模板
     * @return File
     */
    fun createTemplateOfCourse(): File

    /**
     * 创建添加课程与专业目标关系模板
     * @return File
     */
    fun createTemplateOfCourseAndCollegeTargetRelation(collegeId: Long): File

    /**
     * 创建添加课程目标与知识点关系模板
     * @return File
     */
    fun createTemplateOfCourseTargetAndKnowledgeRelation(courseId: Long): File
}