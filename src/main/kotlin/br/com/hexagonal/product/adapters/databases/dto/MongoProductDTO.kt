package br.com.hexagonal.product.adapters.databases.dto

import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.entity.ProductFactory
import jakarta.persistence.Column
import jakarta.persistence.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "product")
data class MongoProductDTO(
    @Id
    @Column(name = "_id")
    override val id: String? = null,
    override val name: String,
    override val price: Double,
    override val description: String? = null,
    override val enabled: Boolean = true
) : ProductDTO {
    override fun toDomain() = ProductFactory.create(id, name, price)

    companion object {
         fun fromDomain(product: Product) = ProductFactory.create(
             id = product.id?.toString(),
             name = product.name,
             price = product.price
         )
     }

}