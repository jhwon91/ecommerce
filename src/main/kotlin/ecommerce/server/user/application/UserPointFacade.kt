package ecommerce.server.user.application

import ecommerce.server.user.application.dto.Charge
import ecommerce.server.user.application.dto.GetBalance
import ecommerce.server.user.domain.service.PointHistoryService
import ecommerce.server.user.domain.service.UserPointService
import ecommerce.server.user.domain.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserPointFacade(
    private val userService: UserService,
    private val userPointService: UserPointService,
    private val pointHistoryService: PointHistoryService
) {

    @Transactional
    fun getBalance(userId: Long): GetBalance {
        val user = userService.findUser(userId)
        val userPoint = userPointService.getUserPoint(user)
        return GetBalance.from(userPoint)
    }

    @Transactional
    fun charge(userId: Long, amount: Long): Charge {
        val user = userService.findUser(userId)
        val userPoint = userPointService.chargeUserPoint(user, amount)
        pointHistoryService.createChargeHistory(user, amount)
        return Charge.from(userPoint, amount)
    }
}