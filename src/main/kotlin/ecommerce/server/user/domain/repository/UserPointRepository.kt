package ecommerce.server.user.domain.repository

import ecommerce.server.user.domain.model.UserPoint

interface UserPointRepository {
    fun findByUserId(userId: Long): UserPoint?
    fun save(userPoint: UserPoint): UserPoint
}