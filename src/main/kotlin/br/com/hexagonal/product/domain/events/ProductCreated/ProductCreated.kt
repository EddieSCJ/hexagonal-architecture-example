package br.com.hexagonal.product.domain.events.ProductCreated

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal.product.domain.entity.Product

data class ProductCreated(val product: Product) : Event(EVENT_NAME, product) {

    companion object {
        const val EVENT_NAME = "product.created"
    }
}