package ecommerce.server.user.infra.impl

import ecommerce.server.user.domain.model.PointHistory
import ecommerce.server.user.domain.repository.PointHistoryRepository
import ecommerce.server.user.infra.jpa.JpaPointHistoryRepository
import org.springframework.stereotype.Repository

@Repository
class PointHistoryRepositoryImpl(
    private val jpaPointHistoryRepository: JpaPointHistoryRepository
):PointHistoryRepository {
    override fun save(pointHistory: PointHistory): PointHistory {
        return jpaPointHistoryRepository.save(pointHistory)
    }
}