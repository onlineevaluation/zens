package com.nuc.zens.controller

import com.nuc.zens.result.Result
import com.nuc.zens.service.FileService
import com.nuc.zens.util.ResultUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.InputStreamResource
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.io.File


/**
 * @author 杨晓辉 4/27/2019 4:40 PM
 * 文件上传和下载
 */
@RestController
@RequestMapping("/file")
class FileController {

    @Autowired
    private lateinit var fileService: FileService

    /**
     * 上传学生信息
     * @param file MultipartFile
     * @return Result
     */
    @PostMapping("/excel/{type}")
    fun uploadFile(@PathVariable(name = "type") type: String, @RequestParam("excel") file: MultipartFile): Result {
        if (file.isEmpty) {
            return ResultUtils.error(500, "文件上传失败")
        }
        fileService.uploadExcelFile(file, type)
        return ResultUtils.success()
    }

    @GetMapping("/excel/student")
    fun downloadStudentExcelTemplates(): ResponseEntity<InputStreamResource> {
        val file = fileService.createTemplateOfStudent()
        return downloadExcelStream(file, "student")
    }


    @GetMapping("/excel/title/{courseId}")
    fun downloadTitleExcelTemplates(@PathVariable("courseId") courseId: Long): ResponseEntity<InputStreamResource> {
        val file = fileService.createTemplateOfTitle(courseId)
        return downloadExcelStream(file, "title")
    }

    @GetMapping("/excel/chapter")
    fun downloadCourseExcelTemplates(): ResponseEntity<InputStreamResource> {
        val file = fileService.createTemplateOfChapter()
        return downloadExcelStream(file, "chapter")
    }


    private fun downloadExcelStream(file: File, name: String): ResponseEntity<InputStreamResource> {
        val filePath = file.absolutePath
        val excelFile = FileSystemResource(filePath)
        val headers = HttpHeaders()
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate")
        headers.add("Content-Disposition", String.format("attachment; filename=$name.xlsx"))
        headers.add("Pragma", "no-cache")
        headers.add("Expires", "0")
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(excelFile.contentLength())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(InputStreamResource(excelFile.inputStream))
    }

    @GetMapping("/excel/course")
    fun downloadCourseTemplates(): ResponseEntity<InputStreamResource> {
        val file = fileService.createTemplateOfCourse()
        return downloadExcelStream(file, "course")
    }

    @GetMapping("/excel/courseAndCollege")
    fun downloadCourseAndCollegeTargetRelationTemplates(collegeId:Long): ResponseEntity<InputStreamResource> {
        val file = fileService.createTemplateOfCourseAndCollegeTargetRelation(collegeId)
        return downloadExcelStream(file, "courseAndCollege")
    }

    @GetMapping("/excel/courseTarAndKnowledge")
    fun downloadCourseTargetAndKnowledgeTemplates(courseId:Long): ResponseEntity<InputStreamResource> {
        val file = fileService.createTemplateOfCourseTargetAndKnowledgeRelation(courseId)
        return downloadExcelStream(file, "courseTarAndKnowledge")
    }

}
