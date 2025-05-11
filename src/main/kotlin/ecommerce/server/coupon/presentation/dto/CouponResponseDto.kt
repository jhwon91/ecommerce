package ecommerce.server.coupon.presentation.dto

import ecommerce.server.coupon.application.dto.IssueCoupon
import ecommerce.server.coupon.application.dto.UserCoupons
import ecommerce.server.coupon.domain.DiscountType
import ecommerce.server.coupon.domain.model.CouponIssue
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(description = "사용자 쿠폰 응답")
data class UserCouponsResponse(
    @Schema(description = "쿠폰 발급 ID", example = "1")
    val couponIssueId: Long,

    @Schema(description = "쿠폰 ID", example = "1")
    val couponId: Long,

    @Schema(description = "쿠폰 이름", example = "신규 가입 쿠폰")
    val couponName: String,

    @Schema(description = "할인 타입", example = "FIXED")
    val discountType: DiscountType,

    @Schema(description = "할인 값", example = "5000")
    val discountValue: Long,

    @Schema(description = "발급일", example = "2025-01-01T00:00:00")
    val issuedAt: LocalDateTime,

    @Schema(description = "만료일", example = "2025-01-31T23:59:59")
    val expiryDate: LocalDateTime
){
    companion object {
        fun from(userCoupons: UserCoupons): UserCouponsResponse {
            return UserCouponsResponse(
                couponId = userCoupons.couponId,
                couponIssueId = userCoupons.couponIssueId,
                couponName = userCoupons.couponName,
                discountType = userCoupons.discountType,
                discountValue = userCoupons.discountValue,
                issuedAt = userCoupons.issuedAt,
                expiryDate = userCoupons.expiryDate
            )
        }

        fun listFrom(userCoupons: List<UserCoupons>): List<UserCouponsResponse>{
            return userCoupons.map {issue ->
                from(issue)
            }
        }
    }
}

@Schema(description = "쿠폰 발급 응답")
data class IssueCouponResponse(
    @Schema(description = "쿠폰 발급 ID", example = "1")
    val couponIssueId: Long,

    @Schema(description = "쿠폰 ID", example = "1")
    val couponId: Long,

    @Schema(description = "쿠폰 이름", example = "신규 가입 쿠폰")
    val couponName: String,

    @Schema(description = "할인 타입", example = "FIXED")
    val discountType: DiscountType,

    @Schema(description = "할인 값", example = "5000")
    val discountValue: Long,

    @Schema(description = "발급일", example = "2025-01-01T00:00:00")
    val issuedAt: LocalDateTime,

    @Schema(description = "만료일", example = "2025-01-31T23:59:59")
    val expiryDate: LocalDateTime
){
    companion object {
        fun from(issueCoupon: IssueCoupon): IssueCouponResponse{
            return IssueCouponResponse(
                couponId = issueCoupon.couponId,
                couponIssueId = issueCoupon.couponIssueId,
                couponName = issueCoupon.couponName,
                discountType = issueCoupon.discountType,
                discountValue = issueCoupon.discountValue,
                issuedAt = issueCoupon.issuedAt,
                expiryDate = issueCoupon.expiryDate
            )
        }
    }
}