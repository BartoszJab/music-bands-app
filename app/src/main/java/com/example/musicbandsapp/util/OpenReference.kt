package com.example.musicbandsapp.util

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity

fun openReference(context: Context, uriString: String) {
    val uri = Uri.parse(uriString)
    startActivity(context, Intent(Intent.ACTION_VIEW, uri), null)
}