package ecommerce.server.cart.presentation.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "장바구니 상품 추가 응답")
data class CartResponse(
    @Schema(description = "장바구니 ID", example = "1")
    val cartId: Long,

    @Schema(description = "장바구니 세부 ID", example = "1")
    val cartDetailId: Long,

    @Schema(description = "장바구니 상태", example = "ACTIVE")
    val status: String,

    @Schema(description = "상품 ID", example = "1")
    val productId: Long,

    @Schema(description = "상품 이름", example = "상품A")
    val name: String,

    @Schema(description = "상품 설명", example = "상품A 설명")
    val description: String,

    @Schema(description = "상품 가격", example = "100")
    val price: Int,

    @Schema(description = "총 가격", example = "1000")
    val totalPrice: Int,

    @Schema(description = "총 수량", example = "10")
    val totalQuantity: Int
)