package ecommerce.server.product.application

import ecommerce.server.product.application.dto.GetProductsWithStock
import ecommerce.server.product.domain.service.ProductService
import ecommerce.server.product.domain.service.StockService
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ProductFacade(
    private val productService: ProductService,
    private val stockService: StockService
) {

    @Transactional(readOnly = true)
    fun getProducts(sortBy: String, sortOrder: String, limit: Int): List<GetProductsWithStock>{
        val products = productService.findProducts(sortBy, sortOrder, limit)
        if (products.isEmpty()) return emptyList()

        val productIds = productService.getProductIdsFromProducts(products)
        val stocks = stockService.getStocksByProductIds(productIds)
        val stockMap = stockService.createStockMapByProductIds(stocks)

        return GetProductsWithStock.listFrom(products, stockMap)
    }

}
