package ecommerce.server.user.domain.model

import ecommerce.server.global.BaseEntity
import ecommerce.server.user.domain.TransactionType
import jakarta.persistence.*

@Entity
@Table(name = "PointHistory")
class PointHistory(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    val amount: Long,

    @Enumerated(EnumType.STRING)
    val transactionType: TransactionType

):BaseEntity() {
}