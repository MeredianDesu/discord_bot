package org.yamaneko.ds_bot

import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import org.springframework.stereotype.Component
import org.yamaneko.ds_bot.utils.DateUtil

@Component
class StartingBot: ListenerAdapter() {
    private val dateUtil = DateUtil()
    override fun onReady(event: ReadyEvent) {
        val channelId = "1342960273798987796" // #bot-log channel ID
        val channel = event.jda.getTextChannelById(channelId)
        channel?.sendMessage("```[${dateUtil.getDate()}]The bot has been launched...```")?.queue()
    }
}