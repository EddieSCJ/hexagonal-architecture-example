package br.com.hexagonal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HexagonalBoilerplateApplication

fun main(args: Array<String>) {
    runApplication<HexagonalBoilerplateApplication>(*args)
}
