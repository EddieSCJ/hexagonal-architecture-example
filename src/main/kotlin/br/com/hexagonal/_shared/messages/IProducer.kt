package br.com.hexagonal._shared.messages

interface IProducer {
    fun produce(message: String)
}