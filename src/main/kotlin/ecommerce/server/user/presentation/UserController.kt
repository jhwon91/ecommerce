package ecommerce.server.user.presentation

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserController {

    // TODO: 잔액 조회
    @GetMapping("/{userId}/balance")
    fun getBalance(
        @PathVariable userId:Long
    ):ResponseEntity<String>{
        return ResponseEntity.ok("")
    }

    // TODO: 잔액 충전
    @PostMapping("/{userId}/balance/charge")
    fun chargeBalance(
        @PathVariable userId:Long,
        @RequestBody amount: Long
    ):ResponseEntity<String>{
        return ResponseEntity.ok("")
    }
}