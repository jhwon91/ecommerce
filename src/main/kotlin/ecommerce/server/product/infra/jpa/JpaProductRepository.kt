package ecommerce.server.product.infra.jpa

import ecommerce.server.product.domain.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface JpaProductRepository: JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.stock WHERE p.id = :id")
    fun findByIdWithStock(id: Long): Product?
}