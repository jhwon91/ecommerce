package ecommerce.server.config

import org.slf4j.LoggerFactory
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName

abstract class TestContainerConfig {
    companion object {
        private val logger = LoggerFactory.getLogger(TestContainerConfig::class.java)

        @Container
        val mysqlContainer = MySQLContainer<Nothing>(DockerImageName.parse("mysql:8.0")).apply {
            withDatabaseName("test_db")
            withUsername("test_user")
            withPassword("test_password")
            withReuse(true)
            start()
            logger.info("MySQL Container ID: ${containerId}")
            logger.info("MySQL Container Name: ${containerName}")
            logger.info("MySQL JDBC URL: ${jdbcUrl}")
            logger.info("MySQL Port: ${firstMappedPort}")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mysqlContainer::getJdbcUrl)
            registry.add("spring.datasource.username", mysqlContainer::getUsername)
            registry.add("spring.datasource.password", mysqlContainer::getPassword)
            registry.add("spring.jpa.hibernate.ddl-auto") { "create-drop" }
            registry.add("spring.datasource.driver-class-name") { "com.mysql.cj.jdbc.Driver" }
            registry.add("spring.sql.init.mode") { "never" }
            registry.add("spring.jpa.defer-datasource-initialization") { "false" }
        }
    }
}