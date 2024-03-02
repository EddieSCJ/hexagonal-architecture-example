package br.com.hexagonal.product.adapters.databases

import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.repository.ProductCacheRepository

class RedisAdapter : ProductCacheRepository {
    override fun save(key: String, data: Product) {
        TODO("Not yet implemented")
    }

    override fun delete(key: String) {
        TODO("Not yet implemented")
    }

    override fun find(key: String): Product? {
        TODO("Not yet implemented")
    }

    override fun findAll(): List<Product> {
        TODO("Not yet implemented")
    }

    override fun update(key: String, data: Product) {
        TODO("Not yet implemented")
    }

    override fun exists(key: String): Boolean {
        TODO("Not yet implemented")
    }
}