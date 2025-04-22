package ecommerce.server.user.domain.model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class UserPointTest{
    private lateinit var user: User
    private lateinit var userPoint: UserPoint

    @BeforeEach
    fun setup() {
        user = User(id = 1L, name = "사용자_A")
        userPoint = UserPoint(id = 1L, user = user, amount = 0)
    }

    @Test
    fun `충전 금액이 1000원 이상이면 금액이 증가한다`() {
        // given
        val initAmount = 0L
        val chargeAmount = 1000L

        // when
        userPoint.charge(chargeAmount)

        // then
        assertThat(userPoint.getAmount()).isEqualTo(initAmount+ chargeAmount)
    }

    @Test
    fun `충전 금액이 1000원 미만이면 예외가 발생한다`() {
        val chargeAmount = 10L

        val result = assertThrows<IllegalArgumentException> {
            userPoint.charge(chargeAmount)
        }

        assertThat(result.message).isEqualTo("최소 충전 금액은 1000원 이상이어야 합니다.")
    }

    @Test
    fun `기존 금액이 있을 때 충전하면 합산된다`() {
        // given
        val initAmount = 5000L
        val userPoint = UserPoint(id = 1L, user = user, amount = initAmount)
        val chargeAmount = 3000L

        // when
        userPoint.charge(chargeAmount)

        // then
        assertThat(userPoint.getAmount()).isEqualTo(initAmount + chargeAmount)
    }


}