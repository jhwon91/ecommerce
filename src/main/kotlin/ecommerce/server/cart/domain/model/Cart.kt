package ecommerce.server.cart.domain.model

import ecommerce.server.cart.domain.CartStatus
import ecommerce.server.global.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "cart")
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
    companion object {
        fun createActiveCart(userId: Long): Cart{
            return Cart(
                userId = userId,
                cartStatus = CartStatus.ACTIVE
            )
        }
    }

    fun addProduct(productId: Long, quantity: Long, price: Long): CartDetail {
        val detail = cartDetails.find { it.productId == productId }
        if ( detail != null) {
            detail.quantity += quantity
            return detail
        } else {
            val newDeatil = CartDetail(
                cart = this,
                productId = productId,
                quantity = quantity,
                price = price
            )
            cartDetails.add(newDeatil)
            return newDeatil
        }
    }
}