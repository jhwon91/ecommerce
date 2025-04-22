package ecommerce.server.user.domain.service

import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.repository.UserRepository
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import kotlin.test.Test

class UserServiceTest{
    private val userRepository = mockk<UserRepository>()
    private val userService = UserService(userRepository)

    @Test
    fun `사용자를 찾으면 해당 사용자를 반환한다`() {
        val userId = 1L
        val user = User(id = userId,name = "사용자_A")
        every { userRepository.findById(userId) } returns user

        val result = userService.findUser(userId)

        assertThat(result).isEqualTo(user)
        assertThat(result.id).isEqualTo(userId)
    }

    @Test
    fun `존재하지 않는 사용자 ID로 조회하면 예외가 발생한다`() {
        val userId = 1L
        every { userRepository.findById(userId) } returns null

        val result = assertThrows<IllegalArgumentException> {
            userService.findUser(userId)
        }

        assertThat(result.message).isEqualTo(" $userId 의 사용자를 찾을 수 없습니다. ")
    }
}