package ecommerce.server.coupon.infra.impl

import ecommerce.server.coupon.domain.model.CouponIssue
import ecommerce.server.coupon.domain.repository.CouponIssueRepository
import ecommerce.server.coupon.infra.jpa.JpaCouponIssueRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class CouponIssueResponseImpl(
    private val jpaCouponIssueRepository: JpaCouponIssueRepository
): CouponIssueRepository {
    override fun findByUserIdAndUsedAtIsNullAndExpiryDateAfter(
        userId: Long,
        currentDate: LocalDateTime
    ): List<CouponIssue> {
        return jpaCouponIssueRepository.findByUserIdAndUsedAtIsNullAndExpiryDateAfter(userId, currentDate)
    }

    override fun save(couponIssue: CouponIssue): CouponIssue {
        return jpaCouponIssueRepository.save(couponIssue)
    }
}