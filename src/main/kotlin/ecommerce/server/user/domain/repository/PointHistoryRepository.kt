package ecommerce.server.user.domain.repository

import ecommerce.server.user.domain.model.PointHistory

interface PointHistoryRepository {
    fun save(pointHistory: PointHistory):PointHistory
    fun findById(pointHistoryId: Long):PointHistory?
    fun findByUserId(userId: Long): List<PointHistory>
}