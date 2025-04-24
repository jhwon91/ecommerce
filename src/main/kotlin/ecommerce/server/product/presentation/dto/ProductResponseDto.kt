package ecommerce.server.product.presentation.dto

import ecommerce.server.product.application.dto.GetProductsWithStock
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "상품 조회 응답")
data class ProductResponse(
    @Schema(description = "상품 ID", example = "1")
    val productId: Long,

    @Schema(description = "상품 이름", example = "상품A")
    val name: String,

    @Schema(description = "상품 가격", example = "10")
    val price: Long,

    @Schema(description = "재고 수량", example = "100")
    val stock: Long
){
    companion object{
        fun from(getProductsWithStock: GetProductsWithStock): ProductResponse {
            return ProductResponse(
                productId = getProductsWithStock.productId,
                name = getProductsWithStock.name,
                price = getProductsWithStock.price,
                stock = getProductsWithStock.stock
            )
        }

        fun listFrom(getProductsWithStock: List<GetProductsWithStock>): List<ProductResponse> {
            return getProductsWithStock.map { from(it) }
        }

    }
}