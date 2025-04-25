package ecommerce.server.cart.infra.jpa

import ecommerce.server.cart.domain.CartStatus
import ecommerce.server.cart.domain.model.Cart
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCartRepository:JpaRepository<Cart, Long> {
    fun findByUserIdAndCartStatus(userId: Long, cartStatus: CartStatus): Cart?
    fun save(cart: Cart): Cart
}