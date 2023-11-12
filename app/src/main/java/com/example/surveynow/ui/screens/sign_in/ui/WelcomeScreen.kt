package com.example.surveynow.ui.screens.sign_in.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.surveynow.ui.common.LogoAndTagline
import com.example.surveynow.ui.common.SignInSection
import com.example.surveynow.ui.navigation.Screen
import com.example.surveynow.ui.screens.sign_in.SignInViewModel
import com.example.surveynow.ui.screens.sign_in.SignInUiAction
import com.example.surveynow.ui.screens.sign_in.SignInUiEvent
import com.example.surveynow.ui.screens.sign_in.SignInUiState

@Composable
fun WelcomeScreen(
    viewModel: SignInViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when (event) {
                SignInUiEvent.OnContinueClicked -> navController.navigate(Screen.CreateAccount.route)
                SignInUiEvent.OnSignInAsGuest -> navController.navigate(Screen.Survey.route)
                else -> {}
            }
        }
    }

    WelcomeLayout(
        state = state,
        onAction = viewModel::handleAction
    )
}

@Composable
fun WelcomeLayout(
    state: SignInUiState,
    onAction: (SignInUiAction) -> Unit,
) {
    Column {
        LogoAndTagline(modifier = Modifier.padding(top = 150.dp))
        SignInSection(
            modifier = Modifier.weight(1f),
            onClick = onAction
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWelcomeLayout() {
    WelcomeLayout(state = SignInUiState(), onAction = {})
}