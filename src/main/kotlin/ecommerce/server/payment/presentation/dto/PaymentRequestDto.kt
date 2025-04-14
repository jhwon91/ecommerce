package ecommerce.server.payment.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "결제, 요청")
data class PaymentRequest(
    @Schema(description = "주문 ID", example = "1")
    val orderId: Long,
    @Schema(description = "사용자 ID", example = "1")
    val userId: Long
)