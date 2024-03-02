package br.com.hexagonal.config.messages

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@EnableRabbit
@Configuration
class RabbitConfig {

    @Bean
    fun emailExchange(): TopicExchange { return TopicExchange("email", true, false) }

    @Bean
    fun inboundEmailQueue(): Queue {
        return Queue("email", true, false, false)
    }

    @Bean
    fun inboundEmailExchangeBinding(): Binding {
        return BindingBuilder.bind(inboundEmailQueue()).to(emailExchange()).with("from.*")
    }
}