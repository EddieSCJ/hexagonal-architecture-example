package br.com.hexagonal.product.adapters.databases.dto

import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.entity.ProductFactory
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(name = "products")
class PostgresProductDTO(): ProductDTO{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    override var id: Int? = null
    override var name: String = ""
    override var price: Double = 0.0
    override var description: String? = null
    override var enabled: Boolean = true

    constructor(id: Int?, name: String, price: Double, description: String, enabled: Boolean) : this() {
        this.id = id
        this.name = name
        this.price = price
        this.description = description
        this.enabled = enabled
    }

    override fun toDomain() = ProductFactory.create(id?.toString(), name, price, description, enabled)

    companion object {
        fun fromDomain(product: Product) =
            PostgresProductDTO(
                product.id,
                product.name,
                product.price,
                product.description,
                product.enabled)
    }
}