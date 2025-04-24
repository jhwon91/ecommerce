package ecommerce.server.product.infra.jpa

import ecommerce.server.product.domain.model.Product
import org.springframework.data.jpa.repository.JpaRepository

interface JpaProductRepository: JpaRepository<Product, Long> {

}