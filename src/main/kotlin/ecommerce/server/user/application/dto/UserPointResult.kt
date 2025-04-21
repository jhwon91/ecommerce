package ecommerce.server.user.application.dto

import ecommerce.server.user.domain.model.UserPoint

data class GetBalance(
    val userId: Long,
    val balance: Long
){
    companion object {
        fun from(userPoint: UserPoint): GetBalance {
            return GetBalance(
                userId = userPoint.user.id!!,
                balance = userPoint.getAmount()
            )
        }
    }
}

data class Charge(
    val userId: Long,
    val chargedAmount: Long,
    val totalBalance: Long
){
    companion object {
        fun from(userPoint: UserPoint, amount: Long): Charge {
            return Charge(
                userId = userPoint.user.id!!,
                chargedAmount = amount,
                totalBalance = userPoint.getAmount()
            )
        }
    }
}