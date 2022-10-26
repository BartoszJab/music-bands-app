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

class BandsViewModel(private val bandsService: BandsService) : ViewModel() {

    var isRefreshing by mutableStateOf(false)
    var state by mutableStateOf<Resource<List<Band>>>(Resource.Loading(emptyList()))

    init {
        if (state is Resource.Loading) {
            getBands()
        }
    }

    fun getBands() = viewModelScope.launch {
        state = Resource.Loading()
        state = bandsService.getBands()
    }

    fun refresh() = viewModelScope.launch {
        isRefreshing = true
        state = bandsService.getBands()
        isRefreshing = false
    }
}
