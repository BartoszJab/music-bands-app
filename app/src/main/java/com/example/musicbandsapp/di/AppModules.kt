package com.example.musicbandsapp.di

import androidx.room.Room
import coil.ImageLoader
import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.db.BandsDatabase
import com.example.musicbandsapp.repository.BandsRepositoryImpl
import com.example.musicbandsapp.viewmodel.BandsViewModel
import com.example.musicbandsapp.viewmodel.DetailsViewModel
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        BandsService(
            client = HttpClient(Android) {
                expectSuccess = true
                install(Logging)
                install(ContentNegotiation) { json() }
            },
            context = androidContext()
        )
    }

    single {
        BandsRepositoryImpl(get(), androidContext())
    }

    single {
        Room.databaseBuilder(
            get(),
            BandsDatabase::class.java, "bands-db"
        ).build()
    }

    single {
        val database: BandsDatabase = get()
        database.getBandsDao()
    }

    single {
        ImageLoader.Builder(androidContext()).crossfade(true).build()
    }

    viewModel { BandsViewModel(get()) }

    viewModel { DetailsViewModel(get()) }
}