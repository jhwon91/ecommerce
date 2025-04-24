package ecommerce.server.user

import ecommerce.server.config.TestContainerConfig
import ecommerce.server.helper.CleanUp
import ecommerce.server.user.application.UserPointFacade
import ecommerce.server.user.domain.TransactionType
import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.repository.PointHistoryRepository
import ecommerce.server.user.domain.repository.UserPointRepository
import ecommerce.server.user.domain.repository.UserRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.testcontainers.junit.jupiter.Testcontainers
import kotlin.test.Test

@SpringBootTest
@Testcontainers
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class UserPointIntegrationTest: TestContainerConfig() {

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userPointRepository: UserPointRepository

    @Autowired
    private lateinit var pointHistoryRepository: PointHistoryRepository

    @Autowired
    private lateinit var cleanUp: CleanUp

    @Autowired
    private lateinit var userPointFacade: UserPointFacade

    private lateinit var testUser: User


    @BeforeEach
    fun setup() {
        cleanUp.all()

        // 테스트 데이터 생성
        val user = User( name = "테스트사용자")
        testUser = userRepository.save(user)
    }

    @Test
    fun `사용자 포인트 충전 통합 테스트`() {
        // given
        val amount = 5000L
        val userId = testUser.id!!

        // When
        val result = userPointFacade.charge(userId, amount)

        // Then
        assertThat(result.userId).isEqualTo(userId)
        assertThat(result.totalBalance).isEqualTo(amount)
        assertThat(result.chargedAmount).isEqualTo(amount)


        // DB 검증: UserPoint
        val savedUserPoint = userPointRepository.findByUserId(userId)
        assertThat(savedUserPoint).isNotNull()
        assertThat(savedUserPoint!!.getAmount()).isEqualTo(amount)

        // DB 검증: PointHistory
        val savedHistory = pointHistoryRepository.findById(1L)
        assertThat(savedHistory).isNotNull()
        assertThat(savedHistory!!.amount).isEqualTo(amount)
        assertThat(savedHistory.transactionType).isEqualTo(TransactionType.CHARGE)
    }

    @Test
    fun `사용자 포인트 반복 충전 통합 테스트`() {
        // given
        val amount = 5000L
        val addToAmount = 5000L
        val userId = testUser.id!!

        // When
        val result = userPointFacade.charge(userId, amount)
        val result2 = userPointFacade.charge(userId, addToAmount)

        // Then
        assertThat(result.userId).isEqualTo(userId)
        assertThat(result.totalBalance).isEqualTo(amount)
        assertThat(result.chargedAmount).isEqualTo(amount)

        assertThat(result2.userId).isEqualTo(userId)
        assertThat(result2.totalBalance).isEqualTo(amount + addToAmount)
        assertThat(result2.chargedAmount).isEqualTo(addToAmount)


        // DB 검증: UserPoint
        val savedUserPoint = userPointRepository.findByUserId(userId)
        assertThat(savedUserPoint).isNotNull()
        assertThat(savedUserPoint!!.getAmount()).isEqualTo(amount + addToAmount)

        // DB 검증: PointHistory
        val savedHistory = pointHistoryRepository.findByUserId(userId)
        assertThat(savedHistory.size).isEqualTo(2)
    }
}