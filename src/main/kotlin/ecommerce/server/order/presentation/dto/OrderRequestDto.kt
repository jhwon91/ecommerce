package ecommerce.server.order.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "주문 ,요청")
data class OrderRequest(
    @Schema(description = "사용자 ID", example = "1")
    val userId: Long,

    @Schema(description = "쿠폰 발급 ID", example = "1")
    val couponIssueId: Long
)