package br.com.hexagonal._shared.events

interface IEventDispatcher {
    fun addHandler(eventName: String, handler: IEventHandler)

    fun removeHandler(eventName: String, handler: IEventHandler)

    fun dispatch(eventName: String, event: Event)
}