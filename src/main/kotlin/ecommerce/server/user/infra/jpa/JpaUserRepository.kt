package ecommerce.server.user.infra.jpa

import ecommerce.server.user.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface JpaUserRepository:JpaRepository<User,Long> {
}