package ecommerce.server.user.domain.service

import ecommerce.server.user.domain.TransactionType
import ecommerce.server.user.domain.model.PointHistory
import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.repository.PointHistoryRepository
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class PointHistoryServiceTest{
    private val pointHistoryRepository = mockk<PointHistoryRepository>()
    private val pointHistoryService = PointHistoryService(pointHistoryRepository)

    @Test
    fun `포인트 충전 내역을 생성한다`() {
        val chargeAmount = 1000L
        val user = User(id = 1L,name = "사용자_A")
        val pointHistory = PointHistory(
            id = 1L,
            user = user,
            amount = chargeAmount,
            transactionType = TransactionType.CHARGE
        )
        every { pointHistoryRepository.save(any()) } returns pointHistory

        val result = pointHistoryService.createChargeHistory(user, chargeAmount)

        assertThat(result).isEqualTo(pointHistory)
    }

}