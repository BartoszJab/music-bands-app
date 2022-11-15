package com.example.musicbandsapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicbandsapp.R
import com.example.musicbandsapp.ui.theme.MusicBandsAppTheme

@Composable
fun ErrorView(message: String, onClick: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onClick)
    ) {
        Text(message, style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold))

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Text(stringResource(R.string.tap_to_refresh))

            Spacer(modifier = Modifier.width(8.dp))

            Icon(imageVector = Icons.Filled.Refresh, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun ErrorViewPreview() {
    MusicBandsAppTheme {
        ErrorView(message = "Something went wrong") { }
    }
}