package com.example.musicbandsapp.db

import androidx.room.TypeConverter
import com.example.musicbandsapp.model.Album
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters(private val gson: Gson = Gson()) {

    @TypeConverter
    fun fromStringList(genre: List<String>): String {
        return gson.toJson(genre)
    }

    @TypeConverter
    fun toStringList(myString: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(myString, type)
    }

    @TypeConverter
    fun fromAlbumsList(genre: List<Album>): String {
        return gson.toJson(genre)
    }

    @TypeConverter
    fun toAlbumsList(myString: String): List<Album> {
        val type = object : TypeToken<List<Album>>() {}.type
        return gson.fromJson(myString, type)
    }
}