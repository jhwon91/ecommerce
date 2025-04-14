package ecommerce.server.user.presentation

import ecommerce.server.global.ApiResponse
import ecommerce.server.user.presentation.dto.BalanceResponse
import ecommerce.server.user.presentation.dto.ChargeRequest
import ecommerce.server.user.presentation.dto.ChargeResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController: IUserController {

    // TODO: 잔액 조회
    @GetMapping("/{userId}/balance")
    override fun getBalance(
        @PathVariable userId:Long
    ):ApiResponse<BalanceResponse>{
        val response = BalanceResponse(userId = userId, balance = 1000)
        return ApiResponse(code = 200,"null", response)
    }

    // TODO: 잔액 충전
    @PostMapping("/{userId}/balance/charge")
    override fun chargeBalance(
        @PathVariable userId:Long,
        @RequestBody request: ChargeRequest
    ):ApiResponse<ChargeResponse>{
        val response = ChargeResponse(userId = userId, chargedAmount = 1000, totalBalance = 2000)
        return ApiResponse(code = 200,"null", response)
    }
}