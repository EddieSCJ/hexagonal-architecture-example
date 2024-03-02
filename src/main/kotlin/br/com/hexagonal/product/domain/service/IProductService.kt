package br.com.hexagonal.product.domain.service

import br.com.hexagonal.product.domain.entity.Product

interface IProductService {
    fun createProduct(product: Product): Product

    fun updateProduct(product: Product): Product

    fun deleteProduct(id: String)

    fun getProduct(id: String): Product?

    fun getProducts(): List<Product>
}