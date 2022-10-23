package com.example.musicbandsapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.model.Band
import kotlinx.coroutines.launch

class BandsViewModel(private val bandsService: BandsService): ViewModel() {

    var bands by mutableStateOf<List<Band>>(emptyList())

    fun getBands() = viewModelScope.launch {
        bands = bandsService.getBands()
    }
}