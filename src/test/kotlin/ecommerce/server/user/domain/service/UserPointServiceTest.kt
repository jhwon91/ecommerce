package ecommerce.server.user.domain.service

import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.model.UserPoint
import ecommerce.server.user.domain.repository.UserPointRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test


class UserPointServiceTest{
    private val userPointRepository = mockk<UserPointRepository>()
    private val userPointService = UserPointService(userPointRepository)

    @Test
    fun `사용자 포인트를 찾으면 기존 사용자 포인트를 반환한다`() {
        val user = userCommon
        val userPoint = userPointCommon
        every { userPointRepository.findByUserId(user.id!!) } returns userPoint

        val result = userPointService.getUserPoint(user)

        assertThat(result).isEqualTo(userPoint)
        assertThat(result.user.id).isEqualTo(user.id)
        assertThat(result.getAmount()).isEqualTo(10000)
    }

    @Test
    fun `사용자 포인트를 찾지 못하면 새 사용자 포인트를 생성하고 저장한다`() {
        val user = userCommon
        val userPoint = UserPoint(id = 2L, user = userCommon, amount = 0)
        every { userPointRepository.findByUserId(user.id!!) } returns null
        every { userPointRepository.save(any()) } returns userPoint

        val result = userPointService.getUserPoint(user)

        assertThat(result.user).isEqualTo(user)
        assertThat(result.getAmount()).isEqualTo(0)
        verify { userPointRepository.save(any()) }
    }

    @Test
    fun `사용자 포인트를 충전하면 금액을 추가하고 저장한다`() {
        val chargeAmount = 20000L
        val user = userCommon
        val userPoint = userPointCommon
        every { userPointRepository.findByUserId(user.id!!) } returns userPoint
        every { userPointRepository.save(any()) } returns userPoint

        val result = userPointService.chargeUserPoint(user, chargeAmount)

        assertThat(result.getAmount()).isEqualTo(30000L)
    }

    @Test
    fun `포인트가 없는 사용자가 충전하면 새로운 포인트 객체가 생성된다`() {
        val chargeAmount = 20000L
        val user = userCommon
        val userPoint = UserPoint(id = 2L, user = user, amount = chargeAmount)

        every { userPointRepository.findByUserId(user.id!!) } returns null
        every { userPointRepository.save(any()) } returns userPoint

        val result = userPointService.chargeUserPoint(user, chargeAmount)

        assertThat(result.user).isEqualTo(user)
        assertThat(result.getAmount()).isEqualTo(chargeAmount)
        verify(exactly = 2) { userPointRepository.save(any()) }
    }

    companion object {
        val userCommon = User(1L, "사용자_A")
        val userPointCommon =  UserPoint(id = 1L, user = userCommon, amount = 10000,)
    }
}
