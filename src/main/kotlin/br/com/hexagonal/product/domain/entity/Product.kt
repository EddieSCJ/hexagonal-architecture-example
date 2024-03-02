package br.com.hexagonal.product.domain.entity

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val description: String,
    val enabled: Boolean = true
) {
    fun disable() : Product {
        check(!enabled) { RuntimeException("Product is already disabled") }
        return this.copy(enabled = false)
    }

    fun enable() : Product {
        check(!enabled) { RuntimeException("Product is already enabled") }
        return this.copy(enabled = true)
    }


}