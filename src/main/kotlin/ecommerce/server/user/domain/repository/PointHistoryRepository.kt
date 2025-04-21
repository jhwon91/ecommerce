package ecommerce.server.user.domain.repository

import ecommerce.server.user.domain.model.PointHistory

interface PointHistoryRepository {
    fun save(pointHistory: PointHistory):PointHistory
}