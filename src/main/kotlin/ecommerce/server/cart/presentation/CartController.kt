package ecommerce.server.cart.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/carts")
class CartController {

    //TODO: 장바구니 상품 추가
    @PostMapping
    fun addToCart(
        @RequestBody userId: Long,
        @RequestBody productId: Long,
        @RequestBody quantity: Int,
    ): ResponseEntity<String> {
        return ResponseEntity.ok("")
    }
}