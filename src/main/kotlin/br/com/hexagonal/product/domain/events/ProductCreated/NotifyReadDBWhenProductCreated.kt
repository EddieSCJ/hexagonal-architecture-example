package br.com.hexagonal.product.domain.events.ProductCreated

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal._shared.events.IEventHandler
import br.com.hexagonal._shared.messages.IProducer
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory

class NotifyReadDBWhenProductCreated(
    override val eventHandlerName: String = "NotifyReadDBWhenProductCreated",
    private val iProducer: IProducer
) : IEventHandler {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun handle(event: Event) {
        val productCreatedEvent = event as ProductCreated

        log.info("ProductCreated event received to update read db: $productCreatedEvent")
        iProducer.produce("readdb", ObjectMapper().writeValueAsString(productCreatedEvent))
    }

}