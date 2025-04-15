package ecommerce.server.coupon.domain.model

import ecommerce.server.coupon.domain.DiscountType
import ecommerce.server.global.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "Coupon")
class Coupon(
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
    val expiryDate: LocalDateTime
):BaseEntity() {
}