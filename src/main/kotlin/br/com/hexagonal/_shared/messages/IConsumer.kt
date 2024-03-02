package br.com.hexagonal._shared.messages

interface IConsumer {
    fun consume(message: String)
}