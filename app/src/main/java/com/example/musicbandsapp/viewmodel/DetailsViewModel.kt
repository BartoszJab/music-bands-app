package com.example.musicbandsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.util.Resource

class DetailsViewModel(private val bandsService: BandsService) : ViewModel() {

    suspend fun getBandDetails(id: Long): Resource<Band> = bandsService.getBandDetails(id)
}