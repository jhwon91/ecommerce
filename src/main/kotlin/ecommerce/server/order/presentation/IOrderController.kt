package ecommerce.server.order.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.order.presentation.dto.OrderRequest
import ecommerce.server.order.presentation.dto.OrderResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "05. 주문 API")
interface IOrderController {

    @Operation(summary = "주문 생성", description = "주문을 처리하는 API")
    @PostMapping
    fun makeOrder(
        @RequestBody request: OrderRequest
    ): ApiResponse<OrderResponse>
}