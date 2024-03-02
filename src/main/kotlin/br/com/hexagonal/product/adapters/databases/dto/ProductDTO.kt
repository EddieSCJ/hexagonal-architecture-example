package br.com.hexagonal.product.adapters.databases.dto

import br.com.hexagonal.product.domain.entity.Product
import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import java.util.UUID

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type",
    defaultImpl = PostgresProductDTO::class)
@JsonSubTypes(
    JsonSubTypes.Type(value = PostgresProductDTO::class, name = "postgres"),
    JsonSubTypes.Type(value = MongoProductDTO::class, name = "mongo")
)
interface ProductDTO {
    val id: Any?
    val name: String
    val price: Double
    val description: String?
    val enabled: Boolean

    fun toDomain(): Product

    companion object {
        fun fromDomain(product: Product): ProductDTO = PostgresProductDTO(
            product.id,
            product.name,
            product.price,
            product.description,
            product.enabled
        )
    }
}