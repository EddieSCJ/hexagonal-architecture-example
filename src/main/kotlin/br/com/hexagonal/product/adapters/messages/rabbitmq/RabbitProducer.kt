package br.com.hexagonal.product.adapters.messages.rabbitmq

import br.com.hexagonal._shared.messages.IProducer
import org.springframework.stereotype.Component

@Component
class RabbitProducer : IProducer {
    override fun produce(message: String) {
        TODO("Not yet implemented")
    }
}