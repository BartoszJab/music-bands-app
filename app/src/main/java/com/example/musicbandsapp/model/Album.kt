package com.example.musicbandsapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val name: String,
    val releaseDate: String,
    val coverImage: String?
)
