package ecommerce.server.user.domain.model

import ecommerce.server.global.BaseEntity
import ecommerce.server.user.domain.TransactionType
import jakarta.persistence.*

@Entity
@Table(name = "PointHistory")
class PointHistory(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    val amount: Int,

    @Enumerated(EnumType.STRING)
    val transactionType: TransactionType

):BaseEntity() {
}