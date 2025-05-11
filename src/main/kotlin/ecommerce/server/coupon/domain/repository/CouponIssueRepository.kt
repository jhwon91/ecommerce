package ecommerce.server.coupon.domain.repository

import ecommerce.server.coupon.domain.model.CouponIssue
import java.time.LocalDateTime

interface CouponIssueRepository {
    fun findByUserIdAndUsedAtIsNullAndExpiryDateAfter(
        userId: Long,
        currentDate: LocalDateTime
    ): List<CouponIssue>

    fun save(couponIssue: CouponIssue): CouponIssue
}