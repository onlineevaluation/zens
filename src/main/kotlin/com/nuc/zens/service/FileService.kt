package com.nuc.zens.service

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.FileOutputStream

/**
 * @author 杨晓辉 4/27/2019 7:46 PM
 */
@Service
interface FileService {

    fun uploadExcelFile(file: MultipartFile, type: String)
    fun createTemplateOfStudent(): File
    fun createTemplateOfTitle(courseId: Long): File
    fun createTemplateOfChapter(): File
}