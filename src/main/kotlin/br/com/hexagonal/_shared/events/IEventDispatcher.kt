package br.com.hexagonal._shared.events

interface IEventDispatcher {
    fun addHandler(event: Event, handler: IEventHandler)

    fun removeHandler(event: Event, handler: IEventHandler)

    fun dispatch(event: Event)
}