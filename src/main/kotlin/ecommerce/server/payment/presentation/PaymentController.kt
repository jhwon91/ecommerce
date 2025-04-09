package ecommerce.server.payment.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payments")
class PaymentController {

    //TODO: 결제
    @PostMapping
    fun makePayment(
        @RequestBody orderId: Long
    ):ResponseEntity<String>{
        return ResponseEntity.ok("")
    }
}