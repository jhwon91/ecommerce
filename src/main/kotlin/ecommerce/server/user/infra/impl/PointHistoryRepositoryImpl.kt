package ecommerce.server.user.infra.impl

import ecommerce.server.user.domain.model.PointHistory
import ecommerce.server.user.domain.repository.PointHistoryRepository
import ecommerce.server.user.infra.jpa.JpaPointHistoryRepository
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class PointHistoryRepositoryImpl(
    private val jpaPointHistoryRepository: JpaPointHistoryRepository
):PointHistoryRepository {
    override fun save(pointHistory: PointHistory): PointHistory {
        return jpaPointHistoryRepository.save(pointHistory)
    }

    override fun findById(pointHistoryId: Long): PointHistory? {
        return jpaPointHistoryRepository.findById(pointHistoryId).getOrNull()
    }

    override fun findByUserId(userId: Long): List<PointHistory> {
        return jpaPointHistoryRepository.findByUserId(userId)
    }
}