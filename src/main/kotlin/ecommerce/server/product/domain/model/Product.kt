package ecommerce.server.product.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "Product")
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val price: Long,

    @Column(nullable = false)
    val quantity: Long,

    @OneToOne(mappedBy = "product", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var stock: Stock? = null,
):BaseEntity() {
}