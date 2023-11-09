package com.example.surveynow.ui.navigation

sealed class Screen(val route: String) {
    object Welcome: Screen("welcome")
    object CreateAccount: Screen("createAccount")

    object NavArgs {
    }

    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}