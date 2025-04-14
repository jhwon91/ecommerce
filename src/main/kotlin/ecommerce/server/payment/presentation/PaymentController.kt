package ecommerce.server.payment.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.payment.presentation.dto.PaymentRequest
import ecommerce.server.payment.presentation.dto.PaymentResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/payments")
class PaymentController: IPaymentController {

    //TODO: 결제
    @PostMapping
    override fun makePayment(
        @RequestBody request: PaymentRequest
    ):ApiResponse<PaymentResponse>{
        val response = PaymentResponse(1,1,1000,"PAID", "1asdwer", "2024-01-01")
        return ApiResponse(200,"null",response)
    }
}