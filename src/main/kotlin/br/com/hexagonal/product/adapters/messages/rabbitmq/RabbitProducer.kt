package br.com.hexagonal.product.adapters.messages.rabbitmq

import br.com.hexagonal._shared.messages.IProducer
import org.springframework.amqp.rabbit.core.BatchingRabbitTemplate
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class RabbitProducer(val rabbitTemplate: RabbitTemplate) : IProducer {
    override fun produce(queue: String, message: String) {
        rabbitTemplate.convertAndSend(queue, message)
    }
}