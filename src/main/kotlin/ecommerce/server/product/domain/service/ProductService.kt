package ecommerce.server.product.domain.service

import ecommerce.server.product.domain.model.Product
import ecommerce.server.product.domain.repository.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun findProducts(sortBy: String, sortOrder: String, limit: Int):List<Product>{
        val sort = when(sortOrder) {
            null,"asc" -> Sort.by(sortBy).ascending()
            "desc" -> Sort.by(sortBy).ascending()
            else -> Sort.by(sortBy).ascending()
        }

        val pageable = PageRequest.of(0,limit,sort)
        return productRepository.findAll(pageable).content
    }

    fun getProductIdsFromProducts(products: List<Product>): List<Long> {
        return products.map { it.id!! }
    }
}