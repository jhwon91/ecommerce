package ecommerce.server.cart.domain.repository

import ecommerce.server.cart.domain.CartStatus
import ecommerce.server.cart.domain.model.Cart

interface CartRepository {
    fun findByUserIdAndCartStatus(userId: Long, cartStatus: CartStatus): Cart?
    fun save(cart: Cart): Cart
}