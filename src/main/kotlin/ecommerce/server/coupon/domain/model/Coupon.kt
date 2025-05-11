package ecommerce.server.coupon.domain.model

import ecommerce.server.coupon.domain.DiscountType
import ecommerce.server.global.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "coupon")
class Coupon(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Enumerated(EnumType.STRING)
    val discountType: DiscountType,

    @Column(nullable = false)
    val discountValue: Long,

    @Column(nullable = false)
    val totalQuantity: Long,

    @Column(nullable = false)
    var issuedQuantity: Long = 0,

    @Column(nullable = false)
    val expiryDate: LocalDateTime,

    @OneToMany(mappedBy = "coupon", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val couponIssues: MutableList<CouponIssue> = mutableListOf()
):BaseEntity() {

    // 쿠폰 발급 가능 여부 확인
    fun canIssue(): Boolean {
        return issuedQuantity < totalQuantity && LocalDateTime.now().isBefore(expiryDate)
    }

    fun issue(userId: Long): CouponIssue {
        if (!canIssue()) {
            throw IllegalStateException("쿠폰 발급이 불가능합니다. 수량 초과 또는 만료되었습니다.")
        }
        val couponIssue = CouponIssue.create(this,userId)

        couponIssues.add(couponIssue)
        issuedQuantity++

        return couponIssue
    }

}