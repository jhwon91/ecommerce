package ecommerce.server.product.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "Product")
class Product(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: Long,

    @Column(nullable = false)
    val quantity: Long
):BaseEntity() {
}