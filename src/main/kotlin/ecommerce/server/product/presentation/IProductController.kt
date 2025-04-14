package ecommerce.server.product.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.product.presentation.dto.ProductResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Tag(name = "상품 API")
interface IProductController {

    @Operation(summary = "상품 조회 ", description = "상품 목록을 조회하는 API")
    @GetMapping
    fun getProducts(
        @Parameter(description = "정렬 기준", example = "name")
        @Schema(allowableValues = ["name", "price","stock"])
        @RequestParam sortBy: String,

        @Parameter(description = "정렬 순서 [asc: 오름차순, desc: 내림차순]", example = "asc")
        @Schema(allowableValues = ["asc", "desc"])
        @RequestParam sortOrder: String,

        @Parameter(description = "조회할 개수", example = "10")
        @RequestParam limit: Int
    ): ApiResponse<List<ProductResponse>>

    @Operation(summary = "인기 상품 조회 ", description = "최근 3일간 가장 많이 팔린 상위 5개 상품 정보를 조회하는 API")
    @GetMapping("/popular")
    fun getPopularProducts():ApiResponse<List<ProductResponse>>
}