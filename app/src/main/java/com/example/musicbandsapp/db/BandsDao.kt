package com.example.musicbandsapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.musicbandsapp.model.Band

@Dao
interface BandsDao {

    @Query("SELECT * FROM band")
    fun getAll(): List<Band>

    @Query("SELECT * FROM band WHERE id = :id")
    fun findById(id: Long): Band

    @Insert
    fun insertAll(vararg bands: Band)

    @Delete
    fun delete(band: Band)
}