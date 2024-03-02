package br.com.hexagonal.product.domain.events.ProductCreated

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal.product.domain.entity.Product

data class ProductCreated(override val name: String, val product: Product) : Event(name)