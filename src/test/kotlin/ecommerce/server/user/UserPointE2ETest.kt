package ecommerce.server.user

import com.fasterxml.jackson.databind.ObjectMapper
import ecommerce.server.config.TestContainerConfig
import ecommerce.server.helper.CleanUp
import ecommerce.server.user.domain.model.User
import ecommerce.server.user.domain.model.UserPoint
import ecommerce.server.user.domain.repository.UserPointRepository
import ecommerce.server.user.domain.repository.UserRepository
import ecommerce.server.user.presentation.dto.ChargeRequest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import org.testcontainers.junit.jupiter.Testcontainers
import java.time.Duration
import java.time.Instant
import kotlin.test.Test


@SpringBootTest
@Testcontainers
class UserPointE2ETest: TestContainerConfig() {
    private val logger = LoggerFactory.getLogger(TestContainerConfig::class.java)


    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var userPointRepository: UserPointRepository

    @Autowired
    private lateinit var cleanUp: CleanUp

    @Autowired
    private lateinit var webApplicationContext: WebApplicationContext

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private lateinit var mockMvc: MockMvc
    private lateinit var testUser: User

    @BeforeEach
    fun setUp() {
        cleanUp.all() // DB 초기화
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build()

        // 테스트 데이터 생성
        val user = User( name = "테스트사용자")
        testUser = userRepository.save(user)
    }

    @Test
    fun `사용자_잔액_조회_성공`() {
        // Given: 사용자와 초기 포인트 설정
        val userId = testUser.id
        val initialBalance = 20000L
        var testUserPoint= UserPoint(user = testUser, amount = initialBalance)
        userPointRepository.save(testUserPoint)

        // When: 잔액 조회 요청
        val startTime = Instant.now()
        val result = mockMvc.perform(
            get("/api/users/$userId/balance")
                .accept(MediaType.APPLICATION_JSON)
        )

        // Then: 응답 JSON 데이터
        result.andExpect(status().isOk)
            .andExpect(jsonPath("$.code").value("200"))
            .andExpect(jsonPath("$.message").value("null"))
            .andExpect(jsonPath("$.data.userId").value(userId))
            .andExpect(jsonPath("$.data.balance").value(initialBalance))

        // Then: DB 검증
        val balanceFromDb = userPointRepository.findByUserId(userId!!)
        assertThat(balanceFromDb!!.getAmount()).isEqualTo(initialBalance)

        // Then: 퍼포먼스 체크
        extracted(startTime)
    }

    @Test
    fun `사용자_잔액_충전_성공`() {
        // Given: 사용자와 초기 포인트 설정
        val userId = testUser.id
        val initialBalance = 20000L
        val chargeAmount = 10000L
        var testUserPoint= UserPoint(user = testUser, amount = initialBalance)
        userPointRepository.save(testUserPoint)
        val chargeRequest = ChargeRequest(amount = chargeAmount)


        // When: 잔액 충전 요청
        val startTime = Instant.now()
        val result = mockMvc.perform(
            post("/api/users/$userId/balance/charge")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(chargeRequest))
        )

        // Then: 응답 JSON 데이터
        result.andExpect(status().isOk)
            .andExpect(jsonPath("$.code").value("200"))
            .andExpect(jsonPath("$.message").value("null"))
            .andExpect(jsonPath("$.data.userId").value(userId))
            .andExpect(jsonPath("$.data.chargedAmount").value(chargeAmount))
            .andExpect(jsonPath("$.data.totalBalance").value(initialBalance + chargeAmount))


        // Then: DB 검증
        val balanceFromDb = userPointRepository.findByUserId(userId!!)
        assertThat(balanceFromDb!!.getAmount()).isEqualTo(initialBalance + chargeAmount)

        // Then: 퍼포먼스 체크
        extracted(startTime)
    }

    private fun extracted(startTime: Instant) {
        val rtt = Duration.between(startTime, Instant.now()).toMillis()
        logger.info("퍼포먼스 체크 (RTT) 허용 범위(예: 500ms 이하): = $rtt")
        assertThat(rtt).isLessThanOrEqualTo(500)
    }


}