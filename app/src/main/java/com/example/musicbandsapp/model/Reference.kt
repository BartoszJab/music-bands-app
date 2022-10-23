package com.example.musicbandsapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Reference(
    val spotify: String?,
    val appleMusic: String?,
    val youtube: String?
)
