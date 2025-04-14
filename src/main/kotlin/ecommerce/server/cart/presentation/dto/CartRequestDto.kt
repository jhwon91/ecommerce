package ecommerce.server.cart.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니 상품 추가 요청")
data class CartRequest(
    @Schema(description = "상품 ID", example = "1")
    val productId: Long,

    @Schema(description = "사용자 ID", example = "1")
    val userId: Long,

    @Schema(description = "수량", example = "5")
    val quantity: Int
)