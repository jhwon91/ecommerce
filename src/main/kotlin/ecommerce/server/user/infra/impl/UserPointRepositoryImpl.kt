package ecommerce.server.user.infra.impl

import ecommerce.server.user.domain.model.UserPoint
import ecommerce.server.user.domain.repository.UserPointRepository
import ecommerce.server.user.infra.jpa.JpaUserPointRepository
import org.springframework.stereotype.Repository

@Repository
class UserPointRepositoryImpl(
    private val jpaUserPointRepository: JpaUserPointRepository
):UserPointRepository {
    override fun findByUserId(userId: Long): UserPoint? {
        return jpaUserPointRepository.findByUserId(userId)
    }

    override fun save(userPoint: UserPoint): UserPoint {
        return jpaUserPointRepository.save(userPoint)
    }
}