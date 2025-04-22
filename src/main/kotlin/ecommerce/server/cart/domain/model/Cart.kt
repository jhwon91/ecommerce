package ecommerce.server.cart.domain.model

import ecommerce.server.cart.domain.CartStatus
import ecommerce.server.global.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Cart")
class Cart(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val userId: Long,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val cartStatus: CartStatus = CartStatus.ACTIVE,

    @OneToMany(mappedBy = "cart", cascade = [CascadeType.ALL], orphanRemoval = true)
    val cartDetails: MutableList<CartDetail> = mutableListOf()
):BaseEntity(){

}