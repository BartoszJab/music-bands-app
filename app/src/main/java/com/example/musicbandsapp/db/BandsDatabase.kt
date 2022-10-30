package com.example.musicbandsapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.musicbandsapp.model.Album
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.model.Reference

@Database(
    entities = [Band::class, Album::class, Reference::class],
    version = 1
)

abstract class BandsDatabase: RoomDatabase() {
    abstract fun getBandsDao(): BandsDao
}