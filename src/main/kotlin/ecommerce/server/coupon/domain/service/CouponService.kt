package ecommerce.server.coupon.domain.service

import ecommerce.server.coupon.domain.model.Coupon
import ecommerce.server.coupon.domain.model.CouponIssue
import ecommerce.server.coupon.domain.repository.CouponRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CouponService(
    private val couponRepository: CouponRepository
) {

    @Transactional
    fun validateCoupon(couponId: Long): Coupon {
        val coupon = couponRepository.findByIdWithLock(couponId)
            ?: throw IllegalArgumentException("쿠폰을 찾을 수 없습니다: $couponId")

        if (!coupon.canIssue()) {
            throw IllegalStateException("쿠폰 발급이 불가능한 상태입니다.")
        }
        return coupon
    }
}