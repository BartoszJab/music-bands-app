package com.example.musicbandsapp.model

import androidx.room.Entity
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Reference(
    val spotify: String?,
    val appleMusic: String?,
    val youtube: String?
)
