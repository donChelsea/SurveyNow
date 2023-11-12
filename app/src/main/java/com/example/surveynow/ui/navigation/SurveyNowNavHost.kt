package com.example.surveynow.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.surveynow.ui.screens.results.ResultsViewModel
import com.example.surveynow.ui.screens.results.ui.ResultsScreen
import com.example.surveynow.ui.screens.sign_in.SignInViewModel
import com.example.surveynow.ui.screens.sign_in.ui.CreateAccountScreen
import com.example.surveynow.ui.screens.sign_in.ui.WelcomeScreen
import com.example.surveynow.ui.screens.survey.SurveyViewModel
import com.example.surveynow.ui.screens.survey.ui.SurveyScreen

@Composable
fun SurveyNowNavHost() {
    val navController = rememberNavController()
    val signInViewModel = hiltViewModel<SignInViewModel>()

    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ) {
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(
                viewModel = signInViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.CreateAccount.route) {
            CreateAccountScreen(
                viewModel = signInViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.Survey.route) {
            val surveyViewModel = hiltViewModel<SurveyViewModel>()

            SurveyScreen(
                viewModel = surveyViewModel,
                navController = navController,
            )
        }
        composable(route = Screen.Results.route) {
            val resultsViewModel = hiltViewModel<ResultsViewModel>()

            ResultsScreen(
                viewModel = resultsViewModel,
                navController = navController,
            )
        }
    }
}