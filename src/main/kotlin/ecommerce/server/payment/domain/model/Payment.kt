package ecommerce.server.payment.domain.model

import ecommerce.server.global.BaseEntity
import ecommerce.server.payment.domain.PaymentStatus
import jakarta.persistence.Column
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

class Payment(
    @Column(nullable = false)
    val orderId: Long,

    @Column(nullable = false)
    var amount: Int,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val paymentStatus: PaymentStatus = PaymentStatus.PENDING,

    @Column(name = "transaction_id")
    var transactionId: String? = null
):BaseEntity() {
}