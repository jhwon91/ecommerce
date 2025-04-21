package ecommerce.server.user.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "UserPoint")
class UserPoint(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    private var amount: Long
):BaseEntity() {
    fun charge(amountToAdd: Long){
        require(amountToAdd >= 1000){"최소 충전 금액은 1000원 이상이어야 합니다."}
        this.amount += amountToAdd
    }

    fun getAmount(): Long = amount


}