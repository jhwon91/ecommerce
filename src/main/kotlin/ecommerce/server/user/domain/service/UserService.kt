package ecommerce.server.user.domain.service

import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun findUser(userId: Long):User {
        return userRepository.findById(userId)
            ?: throw IllegalArgumentException(" $userId 의 사용자를 찾을 수 없습니다. ")
    }

    @Transactional
    fun createUser(user:User): User{
        return userRepository.save(user)
    }
}