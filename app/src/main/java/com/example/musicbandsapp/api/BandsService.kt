package com.example.musicbandsapp.api

import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.util.Resource
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class BandsService(
    private val client: HttpClient
) {

    suspend fun getBands(): Resource<List<Band>> {
        return try {
            val data: List<Band> = client.get(URL).body()
            Resource.Success(data)
        } catch (e: Exception) {
            Resource.Error("An error occurred")
        }
    }

    suspend fun getBandDetails(id: Long): Resource<Band> {
        return try {
            val data: List<Band> = client.get(URL).body()
            val band: Band = data.find { it.id == id }!!

            Resource.Success(band)
        } catch (e: Exception) {
            Resource.Error("Could not get details of the band")
        }
    }

    companion object {
        private const val URL = "https://drive.google.com/uc?id=1uxC7jvDGFzDJoNj_zzIGm248fIGEn0fr"
    }
}