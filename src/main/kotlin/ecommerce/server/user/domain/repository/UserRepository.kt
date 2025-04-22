package ecommerce.server.user.domain.repository

import ecommerce.server.user.domain.model.User

interface UserRepository {
    fun findById(userId: Long): User?
    fun save(user:User): User
}