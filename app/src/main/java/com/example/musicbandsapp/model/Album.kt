package com.example.musicbandsapp.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Album(
    val name: String,
    val releaseDate: String,
    val coverImage: String?
)
