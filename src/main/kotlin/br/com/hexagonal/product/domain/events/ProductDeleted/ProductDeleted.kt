package br.com.hexagonal.product.domain.events.ProductDeleted

import br.com.hexagonal._shared.events.Event

data class ProductDeleted(val id: Int) : Event(EVENT_NAME, id) {
    companion object {
        val EVENT_NAME = "product.deleted"
    }
}