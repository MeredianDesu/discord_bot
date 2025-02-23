package org.yamaneko.ds_bot.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtil {
    fun getDate(): String {
        val currentDate = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

        return currentDate.format( formatter )
    }
}