package com.example.musicbandsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.musicbandsapp.di.appModule
import com.example.musicbandsapp.navigation.AppNavHost
import com.example.musicbandsapp.ui.theme.MusicBandsAppTheme
import com.example.musicbandsapp.ui.theme.primaryColor
import com.example.musicbandsapp.ui.theme.secondaryColor
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(appModule)
        }

        installSplashScreen()

        setContent {
            MusicBandsAppTheme {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier.background(
                        brush = Brush.linearGradient(
                            listOf(secondaryColor, primaryColor, Color.Gray)
                        )
                    )
                ) {
                    AppNavHost()
                }
            }
        }
    }
}
