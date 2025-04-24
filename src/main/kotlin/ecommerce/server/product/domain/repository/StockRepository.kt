package ecommerce.server.product.domain.repository

import ecommerce.server.product.domain.model.Stock

interface StockRepository {
    fun findByProductIdIn(productId: List<Long>): List<Stock>
}