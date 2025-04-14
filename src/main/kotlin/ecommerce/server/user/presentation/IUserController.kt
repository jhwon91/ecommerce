package ecommerce.server.user.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.user.presentation.dto.BalanceResponse
import ecommerce.server.user.presentation.dto.ChargeRequest
import ecommerce.server.user.presentation.dto.ChargeResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@Tag(name = "01. 사용자 API")
interface IUserController  {


    @Operation(summary = "잔액 조회 ", description = "사용자의 포인트 잔액을 조회하는 API")
    @GetMapping("/{userId}/balance")
    fun getBalance(
        @Parameter(description = "사용자 ID", example = "1")
        @PathVariable userId:Long
    ): ApiResponse<BalanceResponse>

    @Operation(summary = "잔액 충전 ", description = "사용자의 포인트를 충전하는 API")
    @PostMapping("/{userId}/balance/charge")
    fun chargeBalance(
        @Parameter(description = "사용자 ID", example = "1")
        @PathVariable userId:Long,
        @RequestBody request: ChargeRequest
    ):ApiResponse<ChargeResponse>
}