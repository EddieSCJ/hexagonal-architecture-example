package br.com.hexagonal.product.app

import br.com.hexagonal._shared.events.IEventDispatcher
import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.events.ProductCreated.ProductCreated
import br.com.hexagonal.product.domain.events.ProductDeleted.ProductDeleted
import br.com.hexagonal.product.domain.repository.ProductReaderRepository
import br.com.hexagonal.product.domain.repository.ProductWriterRepository
import br.com.hexagonal.product.domain.service.IProductService
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Scope
import org.springframework.context.annotation.ScopedProxyMode
import org.springframework.stereotype.Service

@Service
@Transactional
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
class ProductService(
    @Qualifier("postgresAdapter") private val productWriterRepository: ProductWriterRepository,
    @Qualifier("mongoAdapter") private val productReaderRepository: ProductReaderRepository,
    private val productEventDispatcher: IEventDispatcher
) : IProductService {
    override fun createProduct(product: Product): Product {
        val productCreated = productWriterRepository.save(product)
        productEventDispatcher.dispatch(ProductCreated.EVENT_NAME, ProductCreated(productCreated))

        return productCreated
    }

    override fun updateProduct(product: Product): Product {
        check(product.validate())
        val productUpdated = productWriterRepository.update(product)
        productEventDispatcher.dispatch(ProductCreated.EVENT_NAME, ProductCreated(productUpdated))

        return productUpdated
    }

    override fun deleteProduct(id: Int) {
        productWriterRepository.deleteById(id)
        productEventDispatcher.dispatch(ProductDeleted.EVENT_NAME, ProductDeleted(id))
    }

    override fun getProduct(id: Int): Product? {
        return productReaderRepository.findById(id)
    }

    override fun getProducts(): List<Product> {
        return productReaderRepository.findAll()
    }

}