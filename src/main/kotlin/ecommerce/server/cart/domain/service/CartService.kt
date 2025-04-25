package ecommerce.server.cart.domain.service

import ecommerce.server.cart.domain.CartStatus
import ecommerce.server.cart.domain.model.Cart
import ecommerce.server.cart.domain.model.CartDetail
import ecommerce.server.cart.domain.repository.CartRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CartService(
    private val cartRepository: CartRepository
) {
    @Transactional
    fun getOrCreateCart(userId: Long): Cart{
        return cartRepository.findByUserIdAndCartStatus(userId, CartStatus.ACTIVE)
            ?: cartRepository.save(Cart.createActiveCart(userId))
    }

    @Transactional
    fun addProductToCart(cart: Cart, productId: Long, quantity: Long, price: Long): Pair<Cart, CartDetail?> {
        val cartDetail = cart.addProduct(productId, quantity, price)
        val savedCart = cartRepository.save(cart)
        val savedCartDetail = savedCart.cartDetails.find { it.productId == productId  }
        return Pair(savedCart, savedCartDetail)
    }
}