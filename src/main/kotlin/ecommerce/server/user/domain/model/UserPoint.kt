package ecommerce.server.user.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.*

@Entity
@Table(name = "user_point")
class UserPoint(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    val user: User,

    @Column(nullable = false)
    private var amount: Long
):BaseEntity() {
    fun charge(amountToAdd: Long){
        require(amountToAdd >= 1000){
            "최소 충전 금액은 1000원 이상이어야 합니다."
        }
        this.amount += amountToAdd
    }

    fun getAmount(): Long = amount


}