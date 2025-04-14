package ecommerce.server.cart.presentation

import ecommerce.server.cart.presentation.dto.CartRequest
import ecommerce.server.cart.presentation.dto.CartResponse
import ecommerce.server.global.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "04. 장바구니 API")
interface ICartController {

    @Operation(summary = "장바구니에 상품 추가 ", description = "상품을 장바구니에 추가 하는 API")
    @PostMapping
    fun addToCart(
        @RequestBody request: CartRequest
    ): ApiResponse<CartResponse>
}