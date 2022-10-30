package com.example.musicbandsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.musicbandsapp.model.Band
import org.koin.core.component.KoinComponent

@Database(
    entities = [Band::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class BandsDatabase : RoomDatabase(), KoinComponent {
    abstract fun getBandsDao(): BandsDao
}