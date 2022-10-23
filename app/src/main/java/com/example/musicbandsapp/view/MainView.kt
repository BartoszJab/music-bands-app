package com.example.musicbandsapp.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicbandsapp.ui.theme.MusicBandsAppTheme
import com.example.musicbandsapp.viewmodel.BandsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MainView(bandsViewModel: BandsViewModel = getViewModel()) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items = bandsViewModel.bands, key = { it.id }) {
            Row(modifier = Modifier.padding(16.dp)) {
                Text(it.name)
            }
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