package ecommerce.server.user.domain.model

import ecommerce.server.global.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "users")
class User(
    @Column(nullable = false)
    val name:String
):BaseEntity() {

}