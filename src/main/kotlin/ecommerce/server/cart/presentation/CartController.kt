package ecommerce.server.cart.presentation

import ecommerce.server.cart.presentation.dto.CartRequest
import ecommerce.server.cart.presentation.dto.CartResponse
import ecommerce.server.global.ApiResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/carts")
class CartController: ICartController {

    //TODO: 장바구니 상품 추가
    @PostMapping
    override fun addToCart(
        @RequestBody request: CartRequest
    ): ApiResponse<CartResponse> {
        val response = CartResponse(1,1,"ACTIVE",1,"상품A","상품A 설명",100,1000,10)
        return ApiResponse(200,"null", response)
    }
}