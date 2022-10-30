package com.example.musicbandsapp.repository

import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.util.Resource

interface BandsRepository {

    suspend fun getBands(isFromCache: Boolean): Resource<List<Band>>

    suspend fun getBandDetails(id: Long): Resource<Band>
}