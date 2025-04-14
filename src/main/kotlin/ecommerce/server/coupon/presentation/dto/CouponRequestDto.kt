package ecommerce.server.coupon.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "쿠폰 발급 요청")
data class IssueCouponRequest(
    @Schema(description = "사용자 ID", example = "1")
    val userId: Long,

    @Schema(description = "쿠폰 ID", example = "1")
    val couponId: Long
)