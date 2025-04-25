package ecommerce.server.product.domain.repository

import ecommerce.server.product.domain.model.Product
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface ProductRepository {
    fun findAll(pageable: Pageable): Page<Product>
    fun findById(productId: Long): Product?
    fun findByIdWithStock(productId: Long): Product?
    fun save(product: Product): Product
}