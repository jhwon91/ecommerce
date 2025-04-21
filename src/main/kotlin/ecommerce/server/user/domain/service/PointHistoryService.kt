package ecommerce.server.user.domain.service

import ecommerce.server.user.domain.TransactionType
import ecommerce.server.user.domain.model.PointHistory
import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.repository.PointHistoryRepository
import org.springframework.stereotype.Service

@Service
class PointHistoryService(
    private val pointHistoryRepository: PointHistoryRepository
) {
    fun createChargeHistory(user: User, amount: Long):PointHistory {
        val newPointHistory = PointHistory(
            user = user,
            amount = amount,
            transactionType = TransactionType.CHARGE
        )

        return pointHistoryRepository.save(newPointHistory)
    }
}