package ecommerce.server.cart.application.dto

data class AddProductToCartCommand(
    val productId: Long,
    val userId: Long,
    val quantity: Long
)