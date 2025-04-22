package ecommerce.server.user.infra.jpa

import ecommerce.server.user.domain.model.PointHistory
import org.springframework.data.jpa.repository.JpaRepository

interface JpaPointHistoryRepository:JpaRepository<PointHistory, Long> {
    fun findByUserId(userId: Long): List<PointHistory>
}