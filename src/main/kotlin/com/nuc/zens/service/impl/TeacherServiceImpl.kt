package com.nuc.zens.service.impl

import com.nuc.zens.po.Student
import com.nuc.zens.po.Teacher
import com.nuc.zens.po.User
import com.nuc.zens.po.UserAndRole
import com.nuc.zens.repository.TeacherRepository
import com.nuc.zens.repository.UserAndRoleRepository
import com.nuc.zens.repository.UserRepository
import com.nuc.zens.service.TeacherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @author 杨晓辉 2019/5/8 10:56
 */
@Service
class TeacherServiceImpl : TeacherService {

    @Autowired
    private lateinit var teacherRepository: TeacherRepository

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userAndRoleRepository: UserAndRoleRepository

    @Transactional
    override fun addTeacher(teacherName: String, teacherNumber: String, positionId: Long) {
        val user = User()
        user.username = teacherNumber
        val encode = BCryptPasswordEncoder()
        val password = encode.encode("111111")
        user.password = password
        val userInDB = userRepository.saveAndFlush(user)
        // 设置教师
        val teacher = Teacher()
        teacher.name = teacherName
        teacher.jobNumber = teacherNumber
        teacher.positionId = positionId
        teacher.userId = userInDB.id
        teacherRepository.saveAndFlush(teacher)
        // 设置权限
        userAndRoleRepository.saveAndFlush(UserAndRole().apply {
            this.roleId = 2
            this.userId = userInDB.id
        })
    }
}