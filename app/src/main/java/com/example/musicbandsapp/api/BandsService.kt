package com.example.musicbandsapp.api

import android.content.res.Resources
import com.example.musicbandsapp.R
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
            Resource.Error(Resources.getSystem().getString(R.string.error_occurred))
        }
    }

    companion object {
        private const val URL = "https://drive.google.com/uc?id=1uxC7jvDGFzDJoNj_zzIGm248fIGEn0fr"
    }
}