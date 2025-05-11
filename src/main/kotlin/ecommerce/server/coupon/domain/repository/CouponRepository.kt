package ecommerce.server.coupon.domain.repository

import ecommerce.server.coupon.domain.model.Coupon

interface CouponRepository {
    fun findByIdWithLock(id: Long): Coupon?
    fun findById(id: Long): Coupon?
}