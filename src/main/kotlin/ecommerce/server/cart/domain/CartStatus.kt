package ecommerce.server.cart.domain

/**
 *     ACTIVE : 활성화 상태 (수정 가능)
 *     ORDERED : 주문 완료 상태 (수정 불가)
 */
enum class CartStatus {
    ACTIVE,
    ORDERED
}