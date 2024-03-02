package br.com.hexagonal._shared.events

import org.springframework.stereotype.Component

@Component
class EventDispatcher : IEventDispatcher {
    private val handlers: MutableMap<String, MutableList<IEventHandler>> = mutableMapOf()
    override fun addHandler(eventName: String, handler: IEventHandler) {
        handlers[eventName]?.add(handler) ?: handlers.put(eventName, mutableListOf(handler))
    }

    override fun removeHandler(eventName: String, handler: IEventHandler) {
        handlers[eventName]
            ?.find { it.eventHandlerName == handler.eventHandlerName }
            ?.let { handlers[eventName]?.remove(it) }
    }

    override fun dispatch(eventName: String, event: Event) {
        handlers[eventName]
            ?.forEach { it.handle(event) }
            ?: throw Exception("No handler registered for event: $eventName")
    }

}