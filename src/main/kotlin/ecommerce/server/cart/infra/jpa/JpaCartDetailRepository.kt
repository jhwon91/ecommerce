package ecommerce.server.cart.infra.jpa

import ecommerce.server.cart.domain.model.CartDetail
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCartDetailRepository:JpaRepository<CartDetail,Long> {
}