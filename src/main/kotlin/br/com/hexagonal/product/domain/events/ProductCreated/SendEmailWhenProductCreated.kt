package br.com.hexagonal.product.domain.events.ProductCreated

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal._shared.events.IEventHandler
import br.com.hexagonal._shared.messages.IProducer
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier

class SendEmailWhenProductCreated(
    override val eventHandlerName: String = "SendEmailWhenProductCreated",
    private val iProducer: IProducer
) : IEventHandler {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun handle(event: Event) {
        val productCreatedEvent = event as ProductCreated

        log.info("ProductCreated event received to send email: $productCreatedEvent")
        iProducer.produce("email", event.toString())
    }
}