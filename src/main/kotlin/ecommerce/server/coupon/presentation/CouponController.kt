package ecommerce.server.coupon.presentation

import ecommerce.server.coupon.application.CouponFacade
import ecommerce.server.coupon.presentation.dto.IssueCouponRequest
import ecommerce.server.coupon.presentation.dto.IssueCouponResponse
import ecommerce.server.coupon.presentation.dto.UserCouponsResponse
import ecommerce.server.global.ApiResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/coupons")
class CouponController(
    private val couponFacade: CouponFacade
): ICouponController {

    @GetMapping()
    override fun getUserCoupons(
        @RequestParam userId: Long
    ): ApiResponse<List<UserCouponsResponse>> {
        val response = UserCouponsResponse.listFrom(couponFacade.getUserValidCoupons(userId))
        return ApiResponse(200,"null", response)
    }

    @PostMapping("/issue")
    override fun issueCoupon(
        @RequestBody request: IssueCouponRequest
    ): ApiResponse<IssueCouponResponse> {
        val response = IssueCouponResponse.from(couponFacade.issueFirstComeCoupon(request.couponId, request.userId))
        return ApiResponse(200,"null", response)
    }
}