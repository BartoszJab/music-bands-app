package com.example.musicbandsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.musicbandsapp.view.DetailsView
import com.example.musicbandsapp.view.MainView
import com.example.musicbandsapp.viewmodel.BandsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {

    val bandsViewModel: BandsViewModel = getViewModel()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(Screen.MainScreen.route) {
            MainView(
                navController,
                bandsViewModel = bandsViewModel
            )
        }
        composable(
            "${Screen.DetailsScreen.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) {
            DetailsView(
                itemId = it.arguments?.getLong("id") ?: -1,
                bandsViewModel = bandsViewModel,
                navController = navController
            )
        }
    }
}