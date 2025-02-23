package org.yamaneko.ds_bot

import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.stereotype.Component

@Component
class MessagesResponse: ListenerAdapter() {
    override fun onMessageReceived(event: MessageReceivedEvent) {
        val message = event.message
        val author = message.author
        println(message)
        if ( author.isBot ) return

        if( message.contentRaw == "!q" ) {
            event.channel.sendMessage("й!").queue()
        }
    }
}