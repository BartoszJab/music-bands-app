package com.example.musicbandsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.musicbandsapp.di.appModule
import com.example.musicbandsapp.navigation.AppNavHost
import com.example.musicbandsapp.ui.theme.MusicBandsAppTheme
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
                AppNavHost()
            }
        }
    }
}
