package ecommerce.server.user.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "사용자 포인트 충전 요청")
data class ChargeRequest(
    @Schema(description = "충전 금액", example = "1000")
    val amount: Long
)