package ecommerce.server.coupon.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "CouponIssue")
class CouponIssue(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", nullable = false)
    val coupon: Coupon,

    @Column(nullable = false)
    val userId:Long,

    @Column(nullable = false)
    val issuedAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val expiryDate: LocalDateTime,

    @Column(name = "used_at")
    var usedAt: LocalDateTime? = null
):BaseEntity() {

}