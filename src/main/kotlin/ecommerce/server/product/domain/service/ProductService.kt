package ecommerce.server.product.domain.service

import ecommerce.server.product.domain.model.Product
import ecommerce.server.product.domain.repository.ProductRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository
) {
    fun findProducts(sortBy: String, sortOrder: String?, limit: Int):List<Product>{
        val sort = when(sortOrder) {
            null,"asc" -> Sort.by(sortBy).ascending()
            "desc" -> Sort.by(sortBy).descending()
            else -> Sort.by(sortBy).ascending()
        }

        val pageable = PageRequest.of(0,limit,sort)
        return productRepository.findAll(pageable).content
    }

    fun getProductIdsFromProducts(products: List<Product>): List<Long> {
        return products.map { it.id!! }
    }

    @Transactional(readOnly = true)
    fun findProductById(productId: Long): Product {
        return productRepository.findByIdWithStock(productId)
            ?: throw IllegalArgumentException("{$productId} 상품이 없습니다")
    }

    @Transactional(readOnly = true)
    fun checkStockAvailability(productId: Long, quantity: Long){
        val product = findProductById(productId)

        val stock = product.stock
            ?: throw IllegalArgumentException("{$productId} 의 재고가 없습니다.")

        if(stock.quantity < quantity){
            throw IllegalArgumentException("{$productId}의 재고는 {${stock.quantity}} 입니다. 재고가 부족합니다")
        }
    }

    @Transactional
    fun decreaseStock(productId: Long, quantity: Long) {
        val product = findProductById(productId)

        val stock = product.stock
            ?: throw IllegalArgumentException("{$productId} 의 재고가 없습니다.")

        if(stock.quantity < quantity){
            throw IllegalArgumentException("{$productId}의 재고는 {${stock.quantity}} 입니다. 재고가 부족합니다")
        }

        stock.quantity -= quantity
        productRepository.save(product)
    }
}