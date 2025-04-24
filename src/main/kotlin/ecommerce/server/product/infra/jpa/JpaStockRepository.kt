package ecommerce.server.product.infra.jpa

import ecommerce.server.product.domain.model.Stock
import org.springframework.data.jpa.repository.JpaRepository

interface JpaStockRepository: JpaRepository<Stock, Long>{
    fun findByProductIdIn(productId: List<Long>): List<Stock>
}