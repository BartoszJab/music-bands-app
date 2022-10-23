package com.example.musicbandsapp.api

import com.example.musicbandsapp.model.Band
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class BandsService(
    private val client: HttpClient
) {

    suspend fun getBands(): List<Band> {
        return client.get(URL).body()
    }

    companion object {
        private const val URL = "https://drive.google.com/uc?id=1uxC7jvDGFzDJoNj_zzIGm248fIGEn0fr"
    }
}