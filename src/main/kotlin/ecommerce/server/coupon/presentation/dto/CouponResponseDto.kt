package ecommerce.server.coupon.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(description = "사용자 쿠폰 응답")
data class CouponResponse(
    @Schema(description = "쿠폰 발급 ID", example = "1")
    val couponIssueId: Long,

    @Schema(description = "쿠폰 ID", example = "1")
    val couponId: Long,

    @Schema(description = "쿠폰 이름", example = "신규 가입 쿠폰")
    val couponName: String,

    @Schema(description = "할인 타입", example = "FIXED")
    val discountType: String,

    @Schema(description = "할인 값", example = "5000")
    val discountValue: String,

    @Schema(description = "발급일", example = "2025-01-01T00:00:00")
    val issuedAt: LocalDateTime,

    @Schema(description = "만료일", example = "2025-01-31T23:59:59")
    val expiryDate: LocalDateTime,

    @Schema(description = "사용일", example = "null", nullable = true)
    val usedAt: LocalDateTime?
)