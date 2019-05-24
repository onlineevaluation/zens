package com.nuc.zens.service.impl

import com.nuc.zens.po.Class
import com.nuc.zens.repository.ClassRepository
import com.nuc.zens.repository.StudentRepository
import com.nuc.zens.service.ClassService
import com.nuc.zens.vo.ClassInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author 杨晓辉 2019/5/7 16:21
 */
@Service
@Transactional
class ClassServiceImpl : ClassService {


    @Autowired
    private lateinit var classRepository: ClassRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    override fun getAllClasses(): List<ClassInfo> {
        val classList = classRepository.findAll()
        return getClassInfo(classList)
    }

    /**
     * 添加班级
     * @param name String
     */
    override fun addClass(name: String) {
        val `class` = Class()
        `class`.name = name
        classRepository.save(`class`)
    }


    override fun searchClassName(name: String):List<ClassInfo> {
        val nameLike = "%$name%"
        val classList = classRepository.findByNameLike(nameLike)
        return getClassInfo(classList)
    }


    private fun getClassInfo(classList: List<Class>): List<ClassInfo> {
        return classList.map {
            ClassInfo().apply {
                this.classmateCount = studentRepository.findStudentsByClassId(it.id).count().toLong()
                this.id = it.id
                this.name = it.name
            }

        }
    }
}