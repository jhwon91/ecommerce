package ecommerce.server.coupon.application.dto

import ecommerce.server.coupon.domain.DiscountType
import ecommerce.server.coupon.domain.model.CouponIssue
import java.time.LocalDateTime

data class UserCoupons(
    val couponId: Long,
    val couponIssueId: Long,
    val couponName: String,
    val discountType: DiscountType,
    val discountValue: Long,
    val issuedAt: LocalDateTime,
    val expiryDate: LocalDateTime
){
    companion object {
        fun from(couponIssue: CouponIssue):UserCoupons{
            return UserCoupons(
                couponId = couponIssue.coupon.id!!,
                couponIssueId = couponIssue.id!!,
                couponName = couponIssue.coupon.name,
                discountType = couponIssue.coupon.discountType,
                discountValue = couponIssue.coupon.discountValue,
                issuedAt = couponIssue.issuedAt,
                expiryDate = couponIssue.expiryDate!!
            )
        }

        fun listFrom(couponIssues: List<CouponIssue>): List<UserCoupons> {
            return couponIssues.map {issue ->
                from(issue)
            }
        }
    }
}

data class IssueCoupon(
    val couponId: Long,
    val couponIssueId: Long,
    val couponName: String,
    val discountType: DiscountType,
    val discountValue: Long,
    val issuedAt: LocalDateTime,
    val expiryDate: LocalDateTime
){
    companion object {
        fun from(couponIssue: CouponIssue):IssueCoupon{
            return IssueCoupon(
                couponId = couponIssue.coupon.id!!,
                couponIssueId = couponIssue.id!!,
                couponName = couponIssue.coupon.name,
                discountType = couponIssue.coupon.discountType,
                discountValue = couponIssue.coupon.discountValue,
                issuedAt = couponIssue.issuedAt,
                expiryDate = couponIssue.expiryDate!!
            )
        }
    }
}