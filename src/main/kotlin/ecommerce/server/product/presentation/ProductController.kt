package ecommerce.server.product.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.product.presentation.dto.ProductResponse
import ecommerce.server.user.presentation.dto.BalanceResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController: IProductController {

    //TODO: 상품 조회
    @GetMapping
    override fun getProducts(
        @RequestParam sortBy: String,
        @RequestParam sortOrder: String,
        @RequestParam limit: Int
    ):ApiResponse<List<ProductResponse>>{
        val productA = ProductResponse(1, "상품A", "상품A 설명", 10, 100)
        val productB = ProductResponse(1, "상품B", "상품B 설명", 20, 200)

        val response = listOf(productA, productB)
        return ApiResponse(code = 200,"null", response)
    }

    //TODO: 인기 상품 조회
    @GetMapping("/popular")
    override fun getPopularProducts():ApiResponse<List<ProductResponse>>{
        val productA = ProductResponse(1, "상품A", "상품A 설명", 10, 100)
        val productB = ProductResponse(1, "상품B", "상품B 설명", 20, 200)

        val response = listOf(productA, productB)
        return ApiResponse(code = 200,"null", response)
    }
}