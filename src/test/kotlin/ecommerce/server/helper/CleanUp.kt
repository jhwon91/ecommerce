package ecommerce.server.helper

import jakarta.persistence.EntityManager
import jakarta.persistence.Table
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class CleanUp(
    private var jdbcTemplate: JdbcTemplate,
    private var entityManager: EntityManager
) {
    @Transactional
    fun all() {
        val tables = entityManager.metamodel.entities.map { entity ->
            val tableAnnotation = entity.javaType.getAnnotation(Table::class.java)
            tableAnnotation?.name ?: entity.name
        }

        // 외래키 제약 조건 해제
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 0")

        tables.forEach { table ->
            jdbcTemplate.execute("TRUNCATE table $table")
        }

        // 외래키 제약 조건 복구
        jdbcTemplate.execute("SET FOREIGN_KEY_CHECKS = 1")
    }
}