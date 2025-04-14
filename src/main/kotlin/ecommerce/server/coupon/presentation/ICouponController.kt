package ecommerce.server.coupon.presentation

import ecommerce.server.coupon.presentation.dto.CouponResponse
import ecommerce.server.coupon.presentation.dto.IssueCouponRequest
import ecommerce.server.global.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Tag(name = "03. 쿠폰 API")
interface ICouponController {

    @Operation(summary = "쿠폰 조회 ", description = "사용자가 보유한 쿠폰 목록을 조회하는 API")
    @GetMapping()
    fun getUserCoupons(
        @Parameter(description = "사용자 ID", example = "1")
        @RequestParam userId: Long
    ): ApiResponse<CouponResponse>

    @Operation(summary = "쿠폰 발급 ", description = "사용자에게 쿠폰을 발급 하는 API")
    @PostMapping("/issue")
    fun issueCoupon(
        @RequestBody request: IssueCouponRequest
    ): ApiResponse<CouponResponse>
}