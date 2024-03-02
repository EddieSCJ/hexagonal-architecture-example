package br.com.hexagonal.product.app

import br.com.hexagonal._shared.events.EventDispatcher
import br.com.hexagonal._shared.events.IEventDispatcher
import br.com.hexagonal._shared.messages.IProducer
import br.com.hexagonal.product.domain.events.ProductCreated.NotifyReadDBWhenProductCreated
import br.com.hexagonal.product.domain.events.ProductCreated.ProductCreated
import br.com.hexagonal.product.domain.events.ProductCreated.SendEmailWhenProductCreated
import br.com.hexagonal.product.domain.events.ProductDeleted.NotifyReadDBWhenProductDeleted
import br.com.hexagonal.product.domain.events.ProductDeleted.ProductDeleted
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ProductConfig {

    @Bean
    fun productEventDispatcher(
        @Qualifier("rabbitProducer") rabbitProducer: IProducer,
        @Qualifier("kafkaProducer") kafkaProducer: IProducer
    ): IEventDispatcher {
        val dispatcher = EventDispatcher()
        dispatcher.addHandler(ProductCreated.EVENT_NAME, SendEmailWhenProductCreated(iProducer = rabbitProducer))
        dispatcher.addHandler(ProductCreated.EVENT_NAME, NotifyReadDBWhenProductCreated(iProducer = kafkaProducer))
        dispatcher.addHandler(ProductDeleted.EVENT_NAME, NotifyReadDBWhenProductDeleted(iProducer = kafkaProducer))

        return dispatcher
    }
}