package br.com.hexagonal._shared.events

interface IEventHandler {
    val eventHandlerName: String

    fun handle(event: Event)
}