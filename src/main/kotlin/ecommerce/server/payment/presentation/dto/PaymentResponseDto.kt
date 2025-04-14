package ecommerce.server.payment.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "결제 응답")
data class PaymentResponse(
    @Schema(description = "결제 ID", example = "1")
    val paymentId: Long,

    @Schema(description = "주문 ID", example = "1")
    val orderId: Long,

    @Schema(description = "결제 금액", example = "10000")
    val amount: Long,

    @Schema(description = "결제 상태", example = "PAID")
    val status: String,

    @Schema(description = "transactionId", example = "1asdwer")
    val transactionId: String,

    @Schema(description = "결제 생성일", example = "2024-01-01")
    val createdAt: String
)