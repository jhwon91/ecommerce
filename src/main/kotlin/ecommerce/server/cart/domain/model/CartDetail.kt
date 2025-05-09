package ecommerce.server.cart.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "cart_detail")
class CartDetail(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    val cart: Cart,

    @Column(nullable = false)
    val productId: Long,

    @Column(nullable = false)
    var quantity: Long,

    @Column(nullable = false)
    var price: Long,
): BaseEntity() {
}