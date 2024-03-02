package br.com.hexagonal.product.domain.events.ProductDeleted

import br.com.hexagonal._shared.events.Event

data class ProductDeleted(override val name: String, val id: Int) : Event(name)