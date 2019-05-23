package com.nuc.zens.service.impl

import com.nuc.zens.po.Teacher
import com.nuc.zens.po.User
import com.nuc.zens.po.UserAndRole
import com.nuc.zens.repository.PositionRepository
import com.nuc.zens.repository.TeacherRepository
import com.nuc.zens.repository.UserAndRoleRepository
import com.nuc.zens.repository.UserRepository
import com.nuc.zens.service.TeacherService
import com.nuc.zens.vo.TeacherRoleInfo
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

    @Autowired
    private lateinit var positionRepository: PositionRepository

    @Transactional
    override fun addTeacher(teacherName: String, teacherNumber: String, positionId: Long, sex: Int) {
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
        teacher.sex = sex
        teacherRepository.saveAndFlush(teacher)
        // 设置权限
        userAndRoleRepository.saveAndFlush(UserAndRole().apply {
            this.roleId = 2
            this.userId = userInDB.id
        })
    }

    /**
     * 更新教师信息
     * @param teacherId Long
     * @param name String
     * @param jobNumber String
     * @param positionId Long
     * @param sex Int
     */
    override fun updateTeacher(teacherId: Long, name: String, jobNumber: String, positionId: Long, sex: Int) {
        val teacher = teacherRepository.findById(teacherId).get()
        teacher.positionId = positionId
        teacher.jobNumber = jobNumber
        teacher.sex = sex
        teacher.name = name
        teacherRepository.saveAndFlush(teacher)
    }


    /**
     * 查找所有的教师和相关权限
     */
    override fun findAllTeacherRole(): List<TeacherRoleInfo> {
        val teacherList = teacherRepository.findAll()
        return teacherList.map { teacher ->
            val userAndRoleList = userAndRoleRepository.findByUserId(teacher.userId)
            val roleName = userAndRoleList.map {
                when (it.roleId) {
                    1L -> {
                        "管理员"
                    }
                    2L -> {
                        "教师"
                    }
                    3L -> {
                        "学生"
                    }
                    else -> {
                        "未知"
                    }
                }
            }.toString()
            return@map TeacherRoleInfo().apply {
                this.id = teacher.id
                this.jobNumber = teacher.jobNumber
                this.name = teacher.name
                this.role = roleName
                this.position = positionRepository.findById(teacher.positionId).get().name
            }
        }
    }
}