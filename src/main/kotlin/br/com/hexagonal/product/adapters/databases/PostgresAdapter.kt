package br.com.hexagonal.product.adapters.databases

import br.com.hexagonal.product.adapters.databases.dto.PostgresProductDTO
import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.repository.ProductReaderRepository
import br.com.hexagonal.product.domain.repository.ProductWriterRepository
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.PersistenceContextType
import jakarta.persistence.criteria.CriteriaQuery
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class PostgresAdapter(@PersistenceContext(type = PersistenceContextType.TRANSACTION) val entityManager: EntityManager) : ProductWriterRepository, ProductReaderRepository {

    override fun findAll(): List<Product> {
        val query = entityManager.createQuery("SELECT p FROM PostgresProductDTO p", PostgresProductDTO::class.java)
        return query.resultList.map { it.toDomain() }
    }

    override fun findById(id: String): Product? {
        return entityManager.find(PostgresProductDTO::class.java, id)?.toDomain()
    }

    @Transactional
    override fun save(entity: Product): Product {
        val productDTO = PostgresProductDTO.fromDomain(entity)
        return entityManager.merge(productDTO).toDomain()
    }

    @Transactional
    override fun update(entity: Product): Product {
        val productDTO = PostgresProductDTO.fromDomain(entity)
        entityManager.merge(productDTO)
        return entityManager.find(PostgresProductDTO::class.java, entity.id)?.toDomain() ?: throw RuntimeException("Product not found")
    }

    override fun deleteById(id: String) {
       entityManager.createQuery("DELETE FROM PostgresProductDTO p WHERE p.id = :id")
            .setParameter("id", id)
           .executeUpdate()
    }

}