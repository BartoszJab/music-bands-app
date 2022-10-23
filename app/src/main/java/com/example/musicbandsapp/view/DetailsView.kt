package com.example.musicbandsapp.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.viewmodel.BandsViewModel

@Composable
fun DetailsView(itemId: Long, bandsViewModel: BandsViewModel) {

    val selectedBand: Band? = bandsViewModel.bands.find { it.id == itemId }

    selectedBand?.let { band ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            AsyncImage(
                model = band.bandImage,
                contentDescription = "Band image",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            )
            Text("Members", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Text(band.members.joinToString(", "))

            Spacer(Modifier.height(8.dp))

            Text("Albums", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                items(band.albums) {
                    Box(modifier = Modifier.border(1.dp, Color.Black)) {
                        Column(modifier = Modifier.padding(8.dp)) {
                            Text(it.name)
                            Text(it.releaseDate)
                        }
                    }
                }
            }

            Text("Reference", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
            Column(Modifier.fillMaxWidth()) {
                Text(band.reference.spotify ?: "")
                Text(band.reference.appleMusic ?: "")
                Text(band.reference.youtube ?: "")
            }
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