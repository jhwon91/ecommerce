package ecommerce.server.order.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/orders")
class OrderController {

    //TODO: 주문
    @PostMapping
    fun makeOrder(
        @RequestBody orderId: Long
    ):ResponseEntity<String> {
        return ResponseEntity.ok("")
    }
}