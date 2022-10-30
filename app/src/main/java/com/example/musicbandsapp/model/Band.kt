package com.example.musicbandsapp.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Band(
    @PrimaryKey val id: Long,
    val name: String,
    val origin: String,
    val genre: List<String>,
    val formYear: String,
    val members: List<String>,
    val albums: List<Album>,
    val bandImage: String?,
    val logoImage: String?,
    @Embedded
    val reference: Reference
)
