package ecommerce.server.coupon.infra.impl

import ecommerce.server.coupon.domain.model.Coupon
import ecommerce.server.coupon.domain.repository.CouponRepository
import ecommerce.server.coupon.infra.jpa.JpaCouponRepository
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class CouponResponseImpl(
    private val jpaCouponResponse: JpaCouponRepository
): CouponRepository {
    override fun findByIdWithLock(id: Long): Coupon? {
        return jpaCouponResponse.findByIdWithLock(id)
    }

    override fun findById(id: Long): Coupon? {
        return jpaCouponResponse.findById(id).getOrNull()
    }
}