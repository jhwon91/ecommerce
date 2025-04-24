package ecommerce.server.product.infra.impl

import ecommerce.server.product.domain.model.Product
import ecommerce.server.product.domain.repository.ProductRepository
import ecommerce.server.product.infra.jpa.JpaProductRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val jpaProductRepository: JpaProductRepository
): ProductRepository {
    override fun findAll(pageable: Pageable): Page<Product> {
        return jpaProductRepository.findAll(pageable)
    }
}