package ecommerce.server.cart.application.dto

import ecommerce.server.cart.domain.CartStatus
import ecommerce.server.cart.domain.model.Cart
import ecommerce.server.cart.domain.model.CartDetail
import ecommerce.server.product.domain.model.Product

data class AddProductToCart(
    val cartId: Long,
    val cartDetailId: Long,
    val status: CartStatus,
    val productId: Long,
    val name: String,
    val price: Long,
    val totalPrice: Long,
    val totalQuantity: Long
){
    companion object {
        fun from(cart: Cart, cartDetail: CartDetail, product: Product): AddProductToCart{
            return AddProductToCart(
                cartId = cart.id!!,
                cartDetailId = cartDetail.id!!,
                status = cart.cartStatus,
                productId = cartDetail.productId,
                name = product.name,
                price = cartDetail.price,
                totalPrice = cartDetail.price * cartDetail.quantity,
                totalQuantity =cartDetail.quantity
            )
        }
    }
}