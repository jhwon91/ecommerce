package ecommerce.server.order.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "주문 응답")
data class OrderResponse(
    @Schema(description = "주문 ID", example = "1")
    val orderId: Long,

    @Schema(description = "결제 금액", example = "10000")
    val amount: Long,

    @Schema(description = "주문 상태", example = "COMPLETE")
    val orderStatus: String
)