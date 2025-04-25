package ecommerce.server.cart.infra.impl

import ecommerce.server.cart.domain.CartStatus
import ecommerce.server.cart.domain.model.Cart
import ecommerce.server.cart.domain.repository.CartRepository
import ecommerce.server.cart.infra.jpa.JpaCartRepository
import org.springframework.stereotype.Repository

@Repository
class CartRepositoryImpl(
    private val jpaCartRepository: JpaCartRepository
):CartRepository {
    override fun findByUserIdAndCartStatus(userId: Long, cartStatus: CartStatus): Cart? {
        return jpaCartRepository.findByUserIdAndCartStatus(userId, cartStatus)
    }

    override fun save(cart: Cart): Cart {
        return jpaCartRepository.save(cart)
    }

}