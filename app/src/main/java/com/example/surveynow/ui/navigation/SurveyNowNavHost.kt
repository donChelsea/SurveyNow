package com.example.surveynow.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.surveynow.ui.screens.create_account.ui.CreateAccountScreen
import com.example.surveynow.ui.screens.welcome.WelcomeViewModel
import com.example.surveynow.ui.screens.welcome.ui.WelcomeScreen

@Composable
fun SurveyNowNavHost() {
    val navController = rememberNavController()
    val viewModel = hiltViewModel<WelcomeViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }
        composable(route = Screen.CreateAccount.route) {
            CreateAccountScreen(
                viewModel = viewModel,
                navController = navController,
            )
        }
    }
}