package br.com.hexagonal.product.domain.events.ProductDeleted

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal._shared.events.IEventHandler
import br.com.hexagonal._shared.messages.IProducer
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier

class NotifyReadDBWhenProductDeleted(
    override val eventHandlerName: String = "NotifyReadDBWhenProductDeleted",
    @Qualifier("kafkaProducer") private val iProducer: IProducer
) : IEventHandler {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun handle(event: Event) {
        val productDeletedEvent = event as ProductDeleted

        log.info("ProductDeleted event received to update read db: $productDeletedEvent")
        iProducer.produce("readdb", ObjectMapper().writeValueAsString(productDeletedEvent))
    }

}