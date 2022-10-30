package com.example.musicbandsapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.repository.BandsRepositoryImpl
import com.example.musicbandsapp.util.Resource
import kotlinx.coroutines.launch

class BandsViewModel(private val bandsRepositoryImpl: BandsRepositoryImpl) : ViewModel() {

    var isRefreshing by mutableStateOf(false)
    var state by mutableStateOf<Resource<List<Band>>>(Resource.Loading(emptyList()))
    var showSnackbar by mutableStateOf(false)

    init {
        if (state is Resource.Loading) {
            getBands()
        }
    }

    fun getBands() = viewModelScope.launch {
        state = Resource.Loading()
        state = bandsRepositoryImpl.getBands(false)
    }

    fun refresh() = viewModelScope.launch {
        isRefreshing = true

        when (val resource = bandsRepositoryImpl.getBands(true)) {
            is Resource.Error -> showSnackbar = true
            else -> state = resource
        }

        isRefreshing = false
    }
}
