package com.example.musicbandsapp.view.composable

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.musicbandsapp.R
import com.example.musicbandsapp.model.Reference
import com.example.musicbandsapp.util.openReference

@Composable
fun References(context: Context, reference: Reference) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row {
            Reference(
                resourceId = R.drawable.apple_music_logo,
                description = stringResource(R.string.apple_music),
                onClick = { openReference(context, reference.appleMusic ?: "") }
            )

            Reference(
                resourceId = R.drawable.spotify_logo,
                description = stringResource(R.string.spotify),
                onClick = { openReference(context, reference.spotify ?: "") }
            )
        }

        Reference(
            resourceId = R.drawable.yt_logo,
            description = stringResource(R.string.youtube),
            onClick = { openReference(context, reference.youtube ?: "") }
        )
    }
}