package com.example.musicbandsapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.viewmodel.BandsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailsView(itemId: Long, bandsViewModel: BandsViewModel = getViewModel()) {
    val band: Band? = bandsViewModel.bands.find { it.id == itemId }

    band?.let {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = it.bandImage,
                contentDescription = "Band image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            )

            Text(it.albums.toString())
            Text(it.members.toString())
        }
    } ?: run {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Something went wrong", style = MaterialTheme.typography.h5)
        }
    }
}