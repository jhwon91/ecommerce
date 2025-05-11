package ecommerce.server.coupon.domain.service

import ecommerce.server.coupon.domain.model.Coupon
import ecommerce.server.coupon.domain.model.CouponIssue
import ecommerce.server.coupon.domain.repository.CouponIssueRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class CouponIssueService(
    private val couponIssueRepository: CouponIssueRepository
) {
    @Transactional(readOnly = true)
    fun getValidCouponsByUserId(userId: Long): List<CouponIssue> {
        val currentDate = LocalDateTime.now()
        return couponIssueRepository.findByUserIdAndUsedAtIsNullAndExpiryDateAfter(userId, currentDate)
    }

    @Transactional
    fun issueCoupon(coupon: Coupon, userId: Long): CouponIssue {
        val couponIssue = coupon.issue(userId)
        return couponIssueRepository.save(couponIssue)
    }
}