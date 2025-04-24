package ecommerce.server.product.domain.service

import ecommerce.server.product.domain.model.Product
import ecommerce.server.product.domain.model.Stock
import ecommerce.server.product.domain.repository.StockRepository
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class StockServiceTest{
    private val stockRepository = mockk<StockRepository>()
    private val stockService = StockService(stockRepository)

    @Test
    fun `상품ID로 재고 조회 성공`() {
        val productIds = listOf(1L, 2L)
        val stocks = listOf(
            Stock(1L, product = product1, quantity = 10L),
            Stock(2L, product = product2, quantity = 20L)
        )

        every { stockService.getStocksByProductIds(productIds) } returns stocks

        val result = stockService.getStocksByProductIds(productIds)

        assertThat(result).isEqualTo(stocks)
        assertThat(result).hasSize(2)
        assertThat(result[0].quantity).isEqualTo(10L)
        assertThat(result[1].quantity).isEqualTo(20L)
    }

    @Test
    fun `상품ID 별로 재고 map 생성`() {
        val stocks = listOf(
            Stock(1L, product = product1, quantity = 10L),
            Stock(2L, product = product2, quantity = 20L)
        )
        val expectedMap = mapOf(1L to 10L, 2L to 20L)

        val result = stockService.createStockMapByProductIds(stocks)

        assertThat(result).isEqualTo(expectedMap)
        assertThat(result).hasSize(2)
    }

    companion object{
        val product1 = Product(
            id = 1L,
            name = "상품1",
            price = 10L,
            quantity = 100L
        )
        val product2 = Product(
            id = 2L,
            name = "상품2",
            price = 20L,
            quantity = 200L
        )
    }

}