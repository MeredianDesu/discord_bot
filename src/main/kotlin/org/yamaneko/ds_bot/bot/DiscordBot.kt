package org.yamaneko.ds_bot.bot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.yamaneko.ds_bot.MessagesResponse
import org.yamaneko.ds_bot.StartingBot

@Component
class DiscordBot(
    messagesResponse: MessagesResponse,
    startingBot: StartingBot,
    @Value("\${bot_token}") val token: String
): ListenerAdapter() {
    private lateinit var jda: JDA

    init {
        val jda: JDA = JDABuilder.createDefault(
            token,
            GatewayIntent.GUILD_MESSAGES, // read msg in guilds
            GatewayIntent.MESSAGE_CONTENT, // read msg content
        ).addEventListeners(this, messagesResponse, startingBot).build()

        jda.awaitReady()
    }

    fun displayAdminOperation( message: String ) {
        val logChannel = jda.getTextChannelById("1342955905469124608")
        logChannel?.sendMessage( message )?.queue()
    }
}