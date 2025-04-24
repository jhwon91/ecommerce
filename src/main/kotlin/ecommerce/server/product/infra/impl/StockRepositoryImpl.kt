package ecommerce.server.product.infra.impl

import ecommerce.server.product.domain.model.Stock
import ecommerce.server.product.domain.repository.StockRepository
import ecommerce.server.product.infra.jpa.JpaStockRepository
import org.springframework.stereotype.Repository

@Repository
class StockRepositoryImpl(
    private val jpaStockRepository: JpaStockRepository
): StockRepository {
    override fun findByProductIdIn(productId: List<Long>): List<Stock> {
        return jpaStockRepository.findByProductIdIn(productId)
    }
}