package ecommerce.server.coupon.presentation

import ecommerce.server.coupon.presentation.dto.CouponResponse
import ecommerce.server.coupon.presentation.dto.IssueCouponRequest
import ecommerce.server.global.ApiResponse
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/coupons")
class CouponController: ICouponController {

    //TODO: 사용자 쿠폰 조회
    @GetMapping()
    override fun getUserCoupons(
        @RequestParam userId: Long
    ): ApiResponse<CouponResponse> {
        val response = CouponResponse(
            1, 1, "신규 가입 쿠폰", "FIXED",
            "5000",
            LocalDateTime.parse("2025-01-01T00:00:00"),
            LocalDateTime.parse("2025-01-01T00:00:00"),
            null
        )
        return ApiResponse(200,"null", response)
    }

    //TODO: 쿠폰 발급
    @PostMapping("/issue")
    override fun issueCoupon(
        @RequestBody request: IssueCouponRequest
    ): ApiResponse<CouponResponse> {
        val response = CouponResponse(
            1, 1, "신규 가입 쿠폰", "FIXED",
            "5000",
            LocalDateTime.parse("2025-01-01T00:00:00"),
            LocalDateTime.parse("2025-01-01T00:00:00"),
            null
        )
        return ApiResponse(200,"null", response)
    }
}