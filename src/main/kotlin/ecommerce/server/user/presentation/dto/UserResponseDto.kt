package ecommerce.server.user.presentation.dto

import ecommerce.server.user.application.dto.Charge
import ecommerce.server.user.application.dto.GetBalance
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "잔액 조회 응답")
data class BalanceResponse(
    @Schema(description = "사용자 ID", example = "1")
    val userId: Long,

    @Schema(description = "잔액", example = "20000")
    val balance: Long
){
    companion object {
        fun from(getBalance: GetBalance ):BalanceResponse {
            return BalanceResponse(
                userId = getBalance.userId,
                balance = getBalance.balance
            )
        }
    }
}

@Schema(description = "잔액 충전 응답")
data class ChargeResponse(
    @Schema(description = "사용자 ID", example = "1")
    val userId: Long,

    @Schema(description = "충전된 금액", example = "10000")
    val chargedAmount: Long,

    @Schema(description = "총 잔액", example = "20000")
    val totalBalance: Long
){
    companion object {
        fun from(charge: Charge):ChargeResponse {
            return ChargeResponse(
                userId = charge.userId,
                chargedAmount = charge.chargedAmount,
                totalBalance = charge.totalBalance
            )
        }
    }
}