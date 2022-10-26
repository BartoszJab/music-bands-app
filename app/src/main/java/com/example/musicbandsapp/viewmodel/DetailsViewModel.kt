package com.example.musicbandsapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.util.Resource
import kotlinx.coroutines.launch

class DetailsViewModel(private val bandsService: BandsService) : ViewModel() {

    var state by mutableStateOf<Resource<Band>>(Resource.Loading())

    fun getBandDetails(id: Long) = viewModelScope.launch {
        state = bandsService.getBandDetails(id)
    }
}