package br.com.hexagonal.product.domain.events.ProductCreated

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal._shared.events.IEventHandler

class NotifyReadDBWhenProductCreated(override val eventHandlerName: String = "NotifyReadDBWhenProductCreated") : IEventHandler {
    override fun handle(event: Event) {
        TODO("Not yet implemented")
    }

}