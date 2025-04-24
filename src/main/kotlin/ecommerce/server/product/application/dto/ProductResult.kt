package ecommerce.server.product.application.dto

import ecommerce.server.product.domain.model.Product

data class GetProductsWithStock(
    val productId: Long,
    val name: String,
    val price: Long,
    val stock: Long
){
    companion object {
        fun from(product: Product, stockQuantity: Long): GetProductsWithStock {
            return GetProductsWithStock(
                productId = product.id!!,
                name = product.name,
                price = product.price,
                stock = stockQuantity
            )
        }

        fun listFrom(products: List<Product>, stockMap: Map<Long, Long>): List<GetProductsWithStock> {
            return products.map { product ->
                val stockQuantity = stockMap[product.id] ?: 0L
                from(product, stockQuantity)
            }
        }
    }


}