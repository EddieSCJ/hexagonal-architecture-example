package br.com.hexagonal.product.adapters.messages.rabbitmq

import br.com.hexagonal._shared.messages.IConsumer
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class RabbitConsumer : IConsumer {

    @RabbitListener(queues = ["\${queue.name}"])
    override fun consume(message: String) {
        TODO("Not yet implemented")
    }
}