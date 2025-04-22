package ecommerce.server.order.domain.model

import ecommerce.server.global.BaseEntity
import ecommerce.server.order.domain.OrderStatus
import jakarta.persistence.*

@Entity
@Table(name = "Orders")
class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val userId: Long,

    @Column(updatable = false)
    val couponIssueId: Long,

    @Column(nullable = false)
    val cartId: Long,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val orderStatus: OrderStatus = OrderStatus.WAITING,

    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val orderDetails: MutableList<OrderDetail> = mutableListOf(),
    ):BaseEntity() {

}