package com.example.surveynow.ui.navigation

sealed class Screen(val route: String) {
    object Welcome: Screen("welcome")
    object CreateAccount: Screen("createAccount")
    object Survey: Screen("survey")
    object Results: Screen("results")
}