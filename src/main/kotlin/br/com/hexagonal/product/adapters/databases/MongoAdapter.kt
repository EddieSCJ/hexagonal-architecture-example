package br.com.hexagonal.product.adapters.databases

import br.com.hexagonal.product.adapters.databases.dto.MongoProductDTO
import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.repository.ProductReaderRepository
import br.com.hexagonal.product.domain.repository.ProductWriterRepository
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria.where
import org.springframework.data.mongodb.core.query.Query.query
import org.springframework.data.mongodb.core.remove
import org.springframework.stereotype.Repository

@Repository
class MongoAdapter(val mongoTemplate: MongoTemplate) : ProductReaderRepository, ProductWriterRepository {
    override fun findAll(): List<Product> {
        return mongoTemplate.findAll(MongoProductDTO::class.java).map { it.toDomain() }
    }

    override fun findById(id: String): Product? {
        return mongoTemplate.findById(id, MongoProductDTO::class.java)?.toDomain()
    }

    override fun save(entity: Product): Product {
        val productDTO = MongoProductDTO.fromDomain(entity)
        return mongoTemplate.save(productDTO).toDomain()
    }

    override fun update(entity: Product): Product {
        val productDTO = MongoProductDTO.fromDomain(entity)
        return mongoTemplate.save(productDTO).toDomain()
    }

    override fun deleteById(id: String) {
       mongoTemplate.remove(query(where("_id").`is`(id)), MongoProductDTO::class.java)
    }

}