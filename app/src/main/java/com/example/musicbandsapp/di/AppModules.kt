package com.example.musicbandsapp.di

import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.viewmodel.BandsViewModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        BandsService(client = HttpClient(Android) {
            expectSuccess = true
            install(Logging)
            install(ContentNegotiation) { json() }
        })
    }

    viewModel { BandsViewModel(get()) }
}