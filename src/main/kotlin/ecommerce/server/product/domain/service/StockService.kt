package ecommerce.server.product.domain.service

import ecommerce.server.product.domain.model.Stock
import ecommerce.server.product.domain.repository.StockRepository
import org.springframework.stereotype.Service

@Service
class StockService(
    private val stockRepository: StockRepository
) {
    fun getStocksByProductIds(productIds: List<Long>): List<Stock>{
        return stockRepository.findByProductIdIn(productIds)
    }

    fun createStockMapByProductIds(stocks: List<Stock>): Map<Long, Long>{
        return stocks.associate { it.product.id!! to it.quantity }
    }
}