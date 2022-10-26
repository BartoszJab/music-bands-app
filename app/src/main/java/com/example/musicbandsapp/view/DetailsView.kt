package com.example.musicbandsapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.view.composable.References
import com.example.musicbandsapp.viewmodel.BandsViewModel

@Composable
fun DetailsView(itemId: Long, bandsViewModel: BandsViewModel, navController: NavController) {

    val selectedBand: Band? = bandsViewModel.bands.find { it.id == itemId }
    val state = rememberScrollState()
    val context = LocalContext.current

    selectedBand?.let { band ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = band.name) },
                    navigationIcon = {
                        IconButton(onClick = navController::popBackStack) {
                            Icon(Icons.Filled.ArrowBack, "Back icon")
                        }
                    },
                    elevation = 10.dp
                )
            }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(state)
            ) {
                AsyncImage(
                    model = band.bandImage,
                    contentDescription = "Band image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((LocalConfiguration.current.screenHeightDp * 0.3).dp)
                )

                Text("Members", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
                Text(band.members.joinToString(", "))

                Spacer(Modifier.height(8.dp))

                Text("Reference", style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))
                References(context = context, reference = band.reference)
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