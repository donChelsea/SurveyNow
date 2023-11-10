package com.example.surveynow.ui.screens.welcome.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.surveynow.ui.common.AppHeader
import com.example.surveynow.ui.common.SignInSection
import com.example.surveynow.ui.navigation.Screen
import com.example.surveynow.ui.screens.welcome.WelcomeUiAction
import com.example.surveynow.ui.screens.welcome.WelcomeUiEvent
import com.example.surveynow.ui.screens.welcome.WelcomeUiState
import com.example.surveynow.ui.screens.welcome.WelcomeViewModel

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel,
    navController: NavHostController,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when (event) {
                WelcomeUiEvent.OnContinueClicked -> navController.navigate(Screen.CreateAccount.route)
                WelcomeUiEvent.OnSignInAsGuest -> {}
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
    state: WelcomeUiState,
    onAction: (WelcomeUiAction) -> Unit,
) {
    Column {
        AppHeader(modifier = Modifier.padding(top = 150.dp))
        SignInSection(
            modifier = Modifier.weight(1f),
            onClick = onAction
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewWelcomeLayout() {
    WelcomeLayout(state = WelcomeUiState(), onAction = {})
}