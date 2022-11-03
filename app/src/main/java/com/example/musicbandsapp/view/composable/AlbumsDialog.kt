package com.example.musicbandsapp.view.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.musicbandsapp.model.Album

@Composable
fun AlbumsDialog(albums: List<Album>, onDismissRequest: () -> Unit) {

    val albumsDialogScrollState = rememberScrollState()

    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.heightIn(max = 350.dp),
            elevation = 10.dp
        ) {
            Column {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colors.primary)
                ) {
                    Text(
                        "Albums",
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        ),
                        modifier = Modifier.padding(16.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        "Name",
                        style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic),
                    )
                    Text(
                        "Released",
                        style = TextStyle(fontSize = 20.sp, fontStyle = FontStyle.Italic)
                    )
                }

                Divider()

                Column(
                    modifier = Modifier
                        .verticalScroll(albumsDialogScrollState)
                        .padding(horizontal = 16.dp)
                        .weight(weight = 1f, fill = false)

                ) {
                    albums.forEach {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        ) {
                            Text(it.name)
                            Text(it.releaseDate)
                        }
                    }
                }

                TextButton(
                    onClick = onDismissRequest,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(end = 4.dp)
                ) {
                    Text(
                        "Cancel",
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}
