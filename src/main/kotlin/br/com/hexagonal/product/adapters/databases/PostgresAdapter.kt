package br.com.hexagonal.product.adapters.databases

import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.repository.ProductWriterRepository
import org.springframework.stereotype.Component

@Component
class PostgresAdapter : ProductWriterRepository {
    override fun save(entity: Product): Product {
        TODO("Not yet implemented")
    }

    override fun update(entity: Product): Product {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Product) {
        TODO("Not yet implemented")
    }
}