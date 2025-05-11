package ecommerce.server.coupon.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "coupon_issue")
class CouponIssue(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id", nullable = false)
    val coupon: Coupon,

    @Column(nullable = false)
    val userId:Long,

    @Column(nullable = false)
    val issuedAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    val expiryDate: LocalDateTime? = null,

    @Column(name = "used_at")
    var usedAt: LocalDateTime? = null
):BaseEntity() {
    companion object {
        fun create(coupon: Coupon, userId: Long): CouponIssue {
            return CouponIssue(
                coupon = coupon,
                userId = userId,
                issuedAt = LocalDateTime.now(),
                expiryDate = coupon.expiryDate
            )
        }
    }
}