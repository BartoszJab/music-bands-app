package com.example.musicbandsapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.musicbandsapp.navigation.Screen
import com.example.musicbandsapp.ui.theme.MusicBandsAppTheme
import com.example.musicbandsapp.view.composable.RowItem
import com.example.musicbandsapp.viewmodel.BandsViewModel
import com.example.musicbandsapp.viewmodel.State
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import org.koin.androidx.compose.getViewModel

@Composable
fun MainView(navController: NavController, bandsViewModel: BandsViewModel = getViewModel()) {
    when (bandsViewModel.state) {
        is State.LoadingState -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize(),
            ) {
                CircularProgressIndicator()
            }
        }
        is State.DataState -> {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = { Text("Bands") },
                        elevation = 10.dp
                    )
                }
            ) {
                SwipeRefresh(
                    state = rememberSwipeRefreshState(isRefreshing = bandsViewModel.isRefreshing),
                    onRefresh = { bandsViewModel.refresh() }
                ) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(items = bandsViewModel.bands, key = { it.id }) {
                            RowItem(
                                band = it,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clickable { navController.navigate("${Screen.DetailsScreen.route}/${it.id}") }
                            )

                            Divider()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MusicBandsAppTheme {
//        MainView()
    }
}