package ecommerce.server.product.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController {

    //TODO: 상품 조회
    @GetMapping
    fun getProducts(
        @RequestParam sortBy: String,
        @RequestParam sortOrder: String,
        @RequestParam limit: Int
    ):ResponseEntity<String>{
        return ResponseEntity.ok("")
    }

    //TODO: 인기 상품 조회
    @GetMapping("/popular")
    fun getPopularProducts():ResponseEntity<String>{
        return ResponseEntity.ok("")
    }
}