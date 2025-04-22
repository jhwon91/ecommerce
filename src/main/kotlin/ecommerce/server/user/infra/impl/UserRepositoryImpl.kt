package ecommerce.server.user.infra.impl

import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.repository.UserRepository
import ecommerce.server.user.infra.jpa.JpaUserRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import kotlin.jvm.optionals.getOrNull

@Repository
class UserRepositoryImpl(
    private val jpaUserRepository: JpaUserRepository
): UserRepository {
    override fun findById(userId: Long): User? {
        return jpaUserRepository.findById(userId).getOrNull()
    }

    override fun save(user: User): User {
        return jpaUserRepository.save(user)
    }
}