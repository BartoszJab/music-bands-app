package com.example.musicbandsapp.view.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicbandsapp.model.Band
import com.example.musicbandsapp.ui.theme.MusicBandsAppTheme

@Composable
fun RowItem(band: Band, modifier: Modifier = Modifier) {
    Card(shape = RoundedCornerShape(10.dp), modifier = modifier) {
        Row(Modifier.padding(8.dp)) {
            AsyncCachedImage(
                model = band.logoImage ?: band.bandImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(84.dp)
                    .clip(RoundedCornerShape(percent = 50))
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    band.name,
                    style = TextStyle(
                        fontWeight = FontWeight.W300,
                        fontSize = 24.sp
                    )
                )

                Text(
                    band.genre.toString(),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun RowItemPreview() {
    MusicBandsAppTheme {

    }
}