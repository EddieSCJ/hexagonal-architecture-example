package br.com.hexagonal.product.adapters.messages.rabbitmq

import br.com.hexagonal._shared.messages.IConsumer
import lombok.extern.slf4j.Slf4j
import org.apache.logging.log4j.LogManager.getLogger
import org.apache.logging.log4j.Logger
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
@Slf4j
class RabbitConsumer : IConsumer {

    val log: Logger = getLogger(RabbitConsumer::class.java)

    @RabbitListener(queues = ["email"])
    override fun consume(message: String) {
        log.info("Received email message: $message")
    }
}