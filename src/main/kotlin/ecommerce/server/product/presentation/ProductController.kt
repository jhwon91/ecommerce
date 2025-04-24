package ecommerce.server.product.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.product.application.ProductFacade
import ecommerce.server.product.presentation.dto.ProductResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(
    private val productFacade: ProductFacade
): IProductController {

    @GetMapping
    override fun getProducts(
        @RequestParam(required = false, defaultValue = "name") sortBy: String,
        @RequestParam(required = false, defaultValue = "asc") sortOrder: String,
        @RequestParam(required = false, defaultValue = "10") limit: Int
    ):ApiResponse<List<ProductResponse>>{
        val response = ProductResponse.listFrom(productFacade.getProducts(sortBy, sortOrder, limit))
        return ApiResponse(code = 200,"null", response)
    }

    //TODO: 인기 상품 조회
    @GetMapping("/popular")
    override fun getPopularProducts():ApiResponse<List<ProductResponse>>{
        val productA = ProductResponse(1, "상품A",  10, 100)
        val productB = ProductResponse(1, "상품B",  20, 200)

        val response = listOf(productA, productB)
        return ApiResponse(code = 200,"null", response)
    }
}