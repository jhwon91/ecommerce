package ecommerce.server.coupon.infra.jpa

import ecommerce.server.coupon.domain.model.CouponIssue
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface JpaCouponIssueRepository: JpaRepository<CouponIssue, Long> {
    fun findByUserIdAndUsedAtIsNullAndExpiryDateAfter(
        userId: Long,
        currentDate: LocalDateTime
    ): List<CouponIssue>
}