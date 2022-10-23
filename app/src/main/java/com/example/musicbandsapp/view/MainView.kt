package com.example.musicbandsapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicbandsapp.ui.theme.MusicBandsAppTheme
import com.example.musicbandsapp.view.composable.RowItem
import com.example.musicbandsapp.viewmodel.BandsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MainView(bandsViewModel: BandsViewModel = getViewModel()) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = bandsViewModel.bands, key = { it.id }) {
            RowItem(
                band = it,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { }
            )

            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MusicBandsAppTheme {
        MainView()
    }
}