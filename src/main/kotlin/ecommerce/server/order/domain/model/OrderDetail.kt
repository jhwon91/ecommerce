package ecommerce.server.order.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "OrderDetail")
class OrderDetail(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    val order: Order,

    @Column(nullable = false)
    val productId: Long,

    @Column(nullable = false)
    var quantity: Int,

    @Column(nullable = false)
    var price: Int,
):BaseEntity() {
}