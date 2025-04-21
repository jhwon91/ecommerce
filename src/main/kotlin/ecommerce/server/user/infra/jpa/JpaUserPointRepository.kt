package ecommerce.server.user.infra.jpa

import ecommerce.server.user.domain.model.UserPoint
import org.springframework.data.jpa.repository.JpaRepository

interface JpaUserPointRepository: JpaRepository<UserPoint, Long> {
    fun findByUserId(userId: Long): UserPoint?
}