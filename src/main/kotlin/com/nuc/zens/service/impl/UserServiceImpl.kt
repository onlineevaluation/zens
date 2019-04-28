package com.nuc.zens.service.impl

import com.nuc.zens.exception.ResultException
import com.nuc.zens.po.Role
import com.nuc.zens.po.User
import com.nuc.zens.repository.*
import com.nuc.zens.security.JwtTokenProvider
import com.nuc.zens.service.UserService
import com.nuc.zens.vo.StudentInfo
import com.nuc.zens.vo.UserProfileInfo
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.BeanUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

/**
 * @author 杨晓辉 2018/2/1 15:46
 * 用户信息中心
 */
@Service
class UserServiceImpl : UserService, UserDetailsService  {


    private val logger: Logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userAndRoleRepository: UserAndRoleRepository

    @Autowired
    private lateinit var studentRepository: StudentRepository

    @Autowired
    private lateinit var authenticationManager: AuthenticationManager

    @Autowired
    private lateinit var jwtTokenProvider: JwtTokenProvider

    @Autowired
    private lateinit var roleRepository: RoleRepository

    @Autowired
    private lateinit var teacherRepository: TeacherRepository

    @Autowired
    private lateinit var classRepository: ClassRepository




    /**
     * 通过用户名进行用户查找
     * @param username 用户学号
     * @param password 用户密码
     * @return token 信息
     * @throws ResultException 当用户名称和密码不一致
     */
    override fun login(username: String, password: String): String {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))
        val user = userRepository.findUserByUsername(username) ?: throw ResultException("没有该用户", 500)
        val userAndRole = userAndRoleRepository.findUserAndRoleByUserId(user.id)
        val role = roleRepository.findById(userAndRole.roleId).get()
        // 获得用户角色
        val authList = ArrayList<String>()
        authList.add(role.name)
        return when {
            role.name == "teacher" -> {
                logger.debug("username is ${user.username}")
                val teacher =
                    teacherRepository.findTeacherByJobNumber(user.username) ?: throw ResultException("用户查询失败", 500)
                jwtTokenProvider.createToken(authList, teacher)
            }
            role.name == "student" -> {
                val student =
                    studentRepository.findByStudentNumber(user.username) ?: throw ResultException("用户查询失败", 500)
                jwtTokenProvider.createToken(authList, student)
            }
            else -> "token"
        }

    }

    /**
     * @param username 学号/工号
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findUserByUsername(username)
                ?: throw UsernameNotFoundException("UserParam '$username' not found")
        // 获取 user id
        val u = userRepository.findUserByUsername(username) ?: throw ResultException("没有该用户", 500)

        // 权限查询
        val userAndRole = userAndRoleRepository.findUserAndRoleByUserId(u.id)
        val role = roleRepository.findById(userAndRole.roleId).get()

        return org.springframework.security.core.userdetails.User
            .withUsername(username)
            .password(user.password)
            .authorities(role.name)
            .accountExpired(false)
            .accountLocked(false)
            .credentialsExpired(false)
            .disabled(false)
            .build()
    }


    /**
     * 通过id获取详细信息
     * @param id userId
     */
    override fun profile(id: Long): UserProfileInfo {
        val user = userRepository.findById(id).get()

        val auth = user.authorities.joinToString { it.authority }
        val userProfileInfo = UserProfileInfo()
        when {
            auth.contains("student") -> {
                val student = studentRepository.findByStudentNumber(user.username)
                        ?: throw ResultException("没有该用户", 500)
                BeanUtils.copyProperties(student, userProfileInfo)
                userProfileInfo.number = student.studentNumber
                userProfileInfo.identity = student.id
            }
            auth.contains("teacher") -> {
                val teacher =
                    teacherRepository.findTeacherByJobNumber(user.username) ?: throw ResultException("没有该用户", 500)
                BeanUtils.copyProperties(teacher, userProfileInfo)
                userProfileInfo.identity = teacher.id
                userProfileInfo.number = teacher.jobNumber
            }
            else -> {

            }
        }
        return userProfileInfo
    }


    override fun studentProfile(studentId: Long):StudentInfo {
        val student = studentRepository.findById(studentId).get()
        val studentInfo = StudentInfo()
        BeanUtils.copyProperties(student, studentInfo)
        studentInfo.`class` = classRepository.findById(student.classId).get().name
        return studentInfo
    }

    override fun teacherProfile(teacherId: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
