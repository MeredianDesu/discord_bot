package org.yamaneko.ds_bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DsBotApplication

fun main(args: Array<String>) {
    runApplication<DsBotApplication>(*args)
}
