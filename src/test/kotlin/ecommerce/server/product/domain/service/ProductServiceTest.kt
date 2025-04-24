package ecommerce.server.product.domain.service

import ecommerce.server.product.domain.model.Product
import ecommerce.server.product.domain.repository.ProductRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort


class ProductServiceTest{
    private val productRepository = mockk<ProductRepository>()
    private val productService = ProductService(productRepository)


    @Test
    fun `정렬 기준과 방향, 제한 개수에 맞게 상품 목록을 반환한다`(){
        val sortBy = "name"
        val sortOrder = "asc"
        val limit = 10

        val pageable = PageRequest.of(0, limit, Sort.by(sortBy).ascending())
        val products = listOf(
            Product(id = 1L, name = "상품1", price = 1000L, quantity = 10L),
            Product(id = 2L, name = "상품2", price = 2000L, quantity = 20L)
        )
        val page = PageImpl(products, pageable, products.size.toLong())

        every { productRepository.findAll(pageable) } returns page

        val result = productService.findProducts(sortBy, sortOrder, limit)

        assertThat(result).hasSize(2)
        assertThat(result[0].name).isEqualTo("상품1")
        assertThat(result[1].name).isEqualTo("상품2")
        verify(exactly = 1) { productRepository.findAll(pageable) }
    }

    @Test
    fun `ortOrder가 null이면 오름차순으로 정렬한다`(){
        val sortBy = "name"
        val sortOrder = null
        val limit = 10

        val pageable = PageRequest.of(0, limit, Sort.by(sortBy).ascending())
        val products = listOf(
            Product(id = 1L, name = "상품1", price = 1000L, quantity = 10L),
            Product(id = 2L, name = "상품2", price = 2000L, quantity = 20L)
        )
        val page = PageImpl(products, pageable, products.size.toLong())

        every { productRepository.findAll(pageable) } returns page

        val result = productService.findProducts(sortBy, sortOrder, limit)

        assertThat(result).hasSize(2)
        assertThat(result[0].name).isEqualTo("상품1")
        assertThat(result[1].name).isEqualTo("상품2")
        verify(exactly = 1) { productRepository.findAll(pageable) }
    }

    @Test
    fun `상품 목록에서 ID 목록을 추출한다`(){

        val products = listOf(
            Product(id = 1L, name = "상품1", price = 1000L, quantity = 10L),
            Product(id = 2L, name = "상품2", price = 2000L, quantity = 20L),
            Product(id = 3L, name = "상품3", price = 3000L, quantity = 30L)
        )

        val result = productService.getProductIdsFromProducts(products)

        assertThat(result).hasSize(3)
        assertThat(result).contains(1L, 2L, 3L)
    }

}