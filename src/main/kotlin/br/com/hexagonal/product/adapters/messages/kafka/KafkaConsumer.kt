package br.com.hexagonal.product.adapters.messages.kafka

import br.com.hexagonal._shared.messages.IConsumer
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class KafkaConsumer : IConsumer {

    @KafkaListener(topics = ["\${queue.name}"])
    override fun consume(message: String) {
        TODO("Not yet implemented")
    }
}