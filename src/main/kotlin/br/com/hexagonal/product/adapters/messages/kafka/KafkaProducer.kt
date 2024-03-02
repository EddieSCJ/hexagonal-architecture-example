package br.com.hexagonal.product.adapters.messages.kafka

import br.com.hexagonal._shared.messages.IProducer
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class KafkaProducer(val kafkaTemplate: KafkaTemplate<String, String>) : IProducer {
    override fun produce(queue: String, message: String) {
        kafkaTemplate.send(queue, message)
    }
}