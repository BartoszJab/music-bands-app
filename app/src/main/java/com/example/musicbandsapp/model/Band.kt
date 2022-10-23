package com.example.musicbandsapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Band(
    val id: Long,
    val name: String,
    val origin: String,
    val genre: List<String>,
    val formYear: String,
    val members: List<String>,
    val albums: List<Album>,
    val bandImage: String,
    val logoImage: String,
    val reference: List<Reference>
)
