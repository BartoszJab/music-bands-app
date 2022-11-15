package com.example.musicbandsapp.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.musicbandsapp.R
import com.example.musicbandsapp.util.Resource
import com.example.musicbandsapp.view.composable.AlbumsButton
import com.example.musicbandsapp.view.composable.AlbumsDialog
import com.example.musicbandsapp.view.composable.AsyncCachedImage
import com.example.musicbandsapp.view.composable.References
import com.example.musicbandsapp.viewmodel.DetailsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun DetailsView(
    itemId: Long,
    navController: NavController,
    detailsViewModel: DetailsViewModel = getViewModel()
) {

    LaunchedEffect(Unit) {
        detailsViewModel.getBandDetails(itemId)
    }

    val scrollState = rememberScrollState()
    val context = LocalContext.current
    var showAlbumsDialog by remember { mutableStateOf(false) }

    @Suppress("MoveVariableDeclarationIntoWhen")
    val state = detailsViewModel.state

    if (showAlbumsDialog) {
        detailsViewModel.state.data?.albums?.let {
            AlbumsDialog(albums = it, onDismissRequest = { showAlbumsDialog = false })
        }
    }

    when (state) {
        is Resource.Error -> state.message?.let {
            ErrorView(
                message = it,
                onClick = { detailsViewModel.getBandDetails(itemId) }
            )
        }
        is Resource.Loading -> LoadingView()
        is Resource.Success -> state.data?.let { band ->
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text(text = band.name) },
                        navigationIcon = {
                            IconButton(onClick = navController::popBackStack) {
                                Icon(Icons.Filled.ArrowBack, stringResource(R.string.back_icon_description))
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
                        .verticalScroll(scrollState)
                ) {
                    AsyncCachedImage(
                        model = band.bandImage,
                        contentDescription = stringResource(R.string.band_image_description),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height((LocalConfiguration.current.screenHeightDp * 0.3).dp)
                    )

                    Text(
                        stringResource(R.string.members),
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    )
                    Text(band.members.joinToString(", "))

                    Spacer(Modifier.height(8.dp))

                    AlbumsButton { showAlbumsDialog = true }

                    Text(
                        stringResource(R.string.reference),
                        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    )
                    References(context = context, reference = band.reference)


                }
            }
        }
    }
}
