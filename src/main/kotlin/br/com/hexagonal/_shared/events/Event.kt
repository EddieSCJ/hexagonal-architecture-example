package br.com.hexagonal._shared.events

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
open class Event(val eventName: String, val data: Any) {
    constructor() : this("", Any())
}