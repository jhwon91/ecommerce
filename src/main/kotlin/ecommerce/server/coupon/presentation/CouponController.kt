package ecommerce.server.coupon.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/coupons")
class CouponController {

    //TODO: 사용자 쿠폰 조회
    @GetMapping()
    fun getUserCoupons(
        @RequestParam userId: Long
    ): ResponseEntity<String> {
        return ResponseEntity.ok("")
    }

    //TODO: 쿠폰 발급
    @PostMapping("/issue")
    fun issueCoupon(): ResponseEntity<String> {
        // TODO: 서비스 호출 후 응답 반환
        return ResponseEntity.ok("")
    }
}