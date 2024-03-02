package br.com.hexagonal.product.domain.entity

object ProductFactory {

    fun create(id: String?, name: String, price: Double): Product {
        return Product(id = id?.toInt(), name = name, price = price, description = "", enabled = true)
    }

    fun create(id: String?, name: String, price: Double, description: String?, enabled: Boolean): Product {
        return Product(id = id?.toInt(), name = name, price = price, description = description?:"", enabled = enabled)
    }
}