package ecommerce.server.coupon.application

import ecommerce.server.coupon.application.dto.IssueCoupon
import ecommerce.server.coupon.application.dto.UserCoupons
import ecommerce.server.coupon.domain.service.CouponIssueService
import ecommerce.server.coupon.domain.service.CouponService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CouponFacade(
    private val couponService: CouponService,
    private val couponIssueService: CouponIssueService
) {

    @Transactional(readOnly = true)
    fun getUserValidCoupons(userId: Long): List<UserCoupons>{
        val couponIssues = couponIssueService.getValidCouponsByUserId(userId)
        return UserCoupons.listFrom(couponIssues)
    }

    @Transactional
    fun issueFirstComeCoupon(couponId: Long, userId: Long): IssueCoupon {
        val coupon = couponService.validateCoupon(couponId)
        val couponIssue = couponIssueService.issueCoupon(coupon, userId)
        return IssueCoupon.from(couponIssue)
    }
}