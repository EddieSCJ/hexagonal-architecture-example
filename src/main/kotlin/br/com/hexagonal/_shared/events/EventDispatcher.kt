package br.com.hexagonal._shared.events

import org.springframework.stereotype.Component

@Component
class EventDispatcher : IEventDispatcher {
    private val handlers: MutableMap<String, MutableList<IEventHandler>> = mutableMapOf()
    override fun addHandler(event: Event, handler: IEventHandler) {
        handlers[event.name]?.add(handler) ?: handlers.put(event.name, mutableListOf(handler))
    }

    override fun removeHandler(event: Event, handler: IEventHandler) {
        handlers[event.name]
            ?.find { it.eventHandlerName == handler.eventHandlerName }
            ?.let { handlers[event.name]?.remove(it) }
    }

    override fun dispatch(event: Event) {
        handlers[event.name]
            ?.forEach { it.handle(event) }
            ?: throw Exception("No handler registered for event: ${event.name}")
    }

}