package br.com.hexagonal.product.adapters.databases

import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.repository.ProductReaderRepository
import org.springframework.stereotype.Component

@Component
class MongoAdapter : ProductReaderRepository {
    override fun findAll(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Int): Product? {
        TODO("Not yet implemented")
    }
}