package org.yamaneko.ds_bot.dto

// This DTO responds to which anime was added through the admin panel
data class ReleaseDTO(
    val id: Long? = null,
    val name: String,
    val timestamp: String? = null,

    val user: String? = null,
    val address: String? = null,
    val method: String? = null,
)
