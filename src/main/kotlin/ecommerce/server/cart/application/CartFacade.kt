package ecommerce.server.cart.application

import ecommerce.server.cart.application.dto.AddProductToCart
import ecommerce.server.cart.application.dto.AddProductToCartCommand
import ecommerce.server.cart.domain.service.CartService
import ecommerce.server.product.domain.service.ProductService
import ecommerce.server.user.domain.service.UserService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CartFacade(
    private val userService: UserService,
    private val productService: ProductService,
    private val cartService: CartService,
) {

    @Transactional
    fun addProductToCart(command: AddProductToCartCommand): AddProductToCart{
        userService.findUser(command.userId)
        val product = productService.findProductById(command.productId)
        productService.checkStockAvailability(command.productId, command.quantity)

        var cart = cartService.getOrCreateCart(command.userId)
        val (savedCart, cartDetail) = cartService.addProductToCart(cart, command.productId, command.quantity, product.price)

        return AddProductToCart.from(savedCart, cartDetail!!, product)
    }
}