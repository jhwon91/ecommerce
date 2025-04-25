package ecommerce.server.cart.presentation

import ecommerce.server.cart.application.CartFacade
import ecommerce.server.cart.presentation.dto.CartRequest
import ecommerce.server.cart.presentation.dto.CartResponse
import ecommerce.server.global.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/carts")
class CartController(
    private val cartFacade: CartFacade
): ICartController {

    @PostMapping
    override fun addToCart(
        @RequestBody request: CartRequest
    ): ApiResponse<CartResponse> {
        val response = CartResponse.from(cartFacade.addProductToCart(request.toCommand()))
        return ApiResponse(200,"null", response)
    }
}