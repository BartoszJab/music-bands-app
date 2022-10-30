package com.example.musicbandsapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.musicbandsapp.model.Band

@Dao
interface BandsDao {

    @Query("SELECT * FROM band")
    suspend fun getAll(): List<Band>

    @Query("SELECT * FROM band WHERE id = :id")
    suspend fun findById(id: Long): Band

    @Insert
    suspend fun insertAll(bands: List<Band>)
}