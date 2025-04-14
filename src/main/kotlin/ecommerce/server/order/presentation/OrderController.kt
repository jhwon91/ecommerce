package ecommerce.server.order.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.order.presentation.dto.OrderRequest
import ecommerce.server.order.presentation.dto.OrderResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/orders")
class OrderController: IOrderController {

    //TODO: 주문
    @PostMapping
    override fun makeOrder(
        @RequestBody request: OrderRequest
    ):ApiResponse<OrderResponse> {
        val response = OrderResponse(1, 1000, "COMPLETE")
        return ApiResponse(200,"null", response)
    }
}