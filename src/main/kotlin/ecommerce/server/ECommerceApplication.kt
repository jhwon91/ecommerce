package ecommerce.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ECommerceApplication

fun main(args: Array<String>) {
	runApplication<ECommerceApplication>(*args)
}
