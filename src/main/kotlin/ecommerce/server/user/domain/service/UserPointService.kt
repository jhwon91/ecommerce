package ecommerce.server.user.domain.service

import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.model.UserPoint
import ecommerce.server.user.domain.repository.UserPointRepository
import org.springframework.stereotype.Service

@Service
class UserPointService(
    private val userPointRepository: UserPointRepository
) {

    fun getUserPoint(user: User): UserPoint {
        return userPointRepository.findByUserId(user.id!!)
            ?: UserPoint(user = user, amount = 0).also { userPointRepository.save(it) }
    }

    fun chargeUserPoint(user: User, amount: Long): UserPoint {
        val userPoint = getUserPoint(user)

        userPoint.charge(amount)
        return userPointRepository.save(userPoint)
    }
}