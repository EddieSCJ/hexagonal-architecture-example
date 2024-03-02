package br.com.hexagonal.product.adapters.messages.kafka

import br.com.hexagonal._shared.messages.IProducer
import org.springframework.stereotype.Component

@Component
class KafkaProducer : IProducer {
    override fun produce(message: String) {
        TODO("Not yet implemented")
    }
}