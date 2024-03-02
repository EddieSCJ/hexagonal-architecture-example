package br.com.hexagonal.product.domain.events.ProductDeleted

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal._shared.events.IEventHandler

class NotifyReadDBWhenProductDeleted(override val eventHandlerName: String = "NotifyReadDBWhenProductDeleted") : IEventHandler {
    override fun handle(event: Event) {
        TODO("Not yet implemented")
    }

}