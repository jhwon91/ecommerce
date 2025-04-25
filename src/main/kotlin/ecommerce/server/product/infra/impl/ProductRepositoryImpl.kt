package ecommerce.server.product.infra.impl

import ecommerce.server.product.domain.model.Product
import ecommerce.server.product.domain.repository.ProductRepository
import ecommerce.server.product.infra.jpa.JpaProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository
import kotlin.jvm.optionals.getOrNull

@Repository
class ProductRepositoryImpl(
    private val jpaProductRepository: JpaProductRepository
): ProductRepository {
    override fun findAll(pageable: Pageable): Page<Product> {
        return jpaProductRepository.findAll(pageable)
    }

    override fun findById(productId: Long): Product? {
        return jpaProductRepository.findById(productId).getOrNull()
    }

    override fun findByIdWithStock(productId: Long): Product? {
        return jpaProductRepository.findByIdWithStock(productId)
    }

    override fun save(product: Product): Product {
        return jpaProductRepository.save(product)
    }
}