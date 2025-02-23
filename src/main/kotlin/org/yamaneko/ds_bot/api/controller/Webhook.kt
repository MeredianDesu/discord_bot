package org.yamaneko.ds_bot.api.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.yamaneko.ds_bot.bot.DiscordBot
import org.yamaneko.ds_bot.dto.ReleaseDTO

@RestController
@RequestMapping("webhook")
class Webhook(private val bot: DiscordBot) {

    @GetMapping("")
    fun helloWord(): ResponseEntity<String> {
        return ResponseEntity.ok("Hello, world!")
    }

    @PostMapping("releases")
    fun handleRelease(@RequestBody request: ReleaseDTO) {
        println("handle release")
        handleRequest(request)
    }

    @PostMapping("characters")
    fun handleCharacter(@RequestBody request: ReleaseDTO) {
        println("handle character")
        handleRequest(request)
    }

    private fun handleRequest(request: ReleaseDTO) {
        val message = when (request.method.toString().uppercase()) {
            "POST" -> "added to the library"
            "PATCH" -> "updated"
            else -> "Unknown action"
        }

        bot.displayAdminOperation(
            "```[${request.timestamp}][${request.method}]: [${request.name}][${request.id}] was $message by \"${request.user}\" from ${request.address}```"
        )
    }
}