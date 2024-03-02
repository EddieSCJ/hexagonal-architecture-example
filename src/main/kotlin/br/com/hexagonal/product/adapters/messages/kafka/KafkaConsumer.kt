package br.com.hexagonal.product.adapters.messages.kafka

import br.com.hexagonal._shared.events.Event
import br.com.hexagonal._shared.messages.IConsumer
import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.events.ProductCreated.ProductCreated
import br.com.hexagonal.product.domain.events.ProductDeleted.ProductDeleted
import br.com.hexagonal.product.domain.repository.ProductWriterRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer(
    @Qualifier(value = "mongoAdapter") val productWriterRepository: ProductWriterRepository
) : IConsumer {

    private val log = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["readdb"], groupId = "hexagonal-boilerplate")
    override fun consume(message: String) {
        val event = ObjectMapper().readValue(message, Event::class.java)

        val productCreatedEvent = ProductCreated.EVENT_NAME
        val productDeletedEvent = ProductDeleted.EVENT_NAME

        when (event.eventName) {
            productCreatedEvent -> {
                log.info("ProductCreated event received to update read db: $event")
                val productJson = ObjectMapper().writeValueAsString(event.data)
                val product = ObjectMapper().readValue(productJson, Product::class.java)
                productWriterRepository.save(product)
            }
            productDeletedEvent -> {
                log.info("ProductDeleted event received to delete in read db: $event")
                productWriterRepository.deleteById(event.data as Int)
            }
            else -> log.info("Event not found: $event")
        }
    }
}