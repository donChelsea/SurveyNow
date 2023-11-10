package com.example.surveynow.ui.screens.create_account.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.surveynow.ui.common.AccountSetUp
import com.example.surveynow.ui.common.CreateAccount
import com.example.surveynow.ui.navigation.Screen
import com.example.surveynow.ui.screens.welcome.WelcomeUiAction
import com.example.surveynow.ui.screens.welcome.WelcomeUiEvent
import com.example.surveynow.ui.screens.welcome.WelcomeUiState
import com.example.surveynow.ui.screens.welcome.WelcomeViewModel

@Composable
fun CreateAccountScreen(
    viewModel: WelcomeViewModel,
    navController: NavController,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when (event) {
                WelcomeUiEvent.OnFinish -> {}
                else -> {}
            }
        }
    }

    CreateAccountLayout(
        state = state,
        onAction = viewModel::handleAction
    )
}

@Composable
fun CreateAccountLayout(
    state: WelcomeUiState,
    onAction: (WelcomeUiAction) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        CreateAccount(Modifier.padding(top = 150.dp))
        AccountSetUp(
            email = state.email,
            onClick = onAction,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCreateAccountLayout() {
    CreateAccountLayout(state = WelcomeUiState(), onAction = {})
}