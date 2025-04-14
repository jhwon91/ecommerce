package ecommerce.server.payment.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.payment.presentation.dto.PaymentRequest
import ecommerce.server.payment.presentation.dto.PaymentResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "06. 결제 API")
interface IPaymentController {

    @Operation(summary = "결제 생성", description = "결제를 처리하는 API")
    @PostMapping
    fun makePayment(
        @RequestBody request: PaymentRequest
    ): ApiResponse<PaymentResponse>
}