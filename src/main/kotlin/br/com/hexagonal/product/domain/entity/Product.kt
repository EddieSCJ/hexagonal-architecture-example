package br.com.hexagonal.product.domain.entity

data class Product(
    val id: Int? = null,
    val name: String,
    val price: Double,
    val description: String,
    val enabled: Boolean = true
) {

    constructor() : this(null, "", 0.0, "")
    fun disable() : Product {
        check(!enabled) { RuntimeException("Product is already disabled") }
        return this.copy(enabled = false)
    }

    fun enable() : Product {
        check(!enabled) { RuntimeException("Product is already enabled") }
        return this.copy(enabled = true)
    }

    fun validate() : Boolean {
        return name.isNotEmpty() && price > 0 && description.isNotEmpty() && enabled
    }
}