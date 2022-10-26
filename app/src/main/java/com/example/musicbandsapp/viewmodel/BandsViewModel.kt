package com.example.musicbandsapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicbandsapp.api.BandsService
import com.example.musicbandsapp.model.Band
import kotlinx.coroutines.launch

class BandsViewModel(private val bandsService: BandsService) : ViewModel() {

    var bands by mutableStateOf<List<Band>>(emptyList())
    var isRefreshing by mutableStateOf(false)
    var state by mutableStateOf<State>(State.LoadingState)

    init {
        if (bands.isEmpty()) {
            getBands()
        }
    }

    private fun getBands() = viewModelScope.launch {
        bands = bandsService.getBands()

        if (bands.isNotEmpty()) state = State.DataState(bands)
    }

    fun refresh() = viewModelScope.launch {
        isRefreshing = true
        bands = bandsService.getBands()
        isRefreshing = false
    }
}

sealed class State {
    object LoadingState : State()
    data class DataState(val data: List<Band>) : State()
}