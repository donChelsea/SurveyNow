package com.example.surveynow.ui.screens.sign_in.ui

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
import com.example.surveynow.ui.common.AccountSetup
import com.example.surveynow.ui.common.CreateAccount
import com.example.surveynow.ui.navigation.Screen
import com.example.surveynow.ui.screens.sign_in.SignInViewModel
import com.example.surveynow.ui.screens.sign_in.SignInUiAction
import com.example.surveynow.ui.screens.sign_in.SignInUiEvent
import com.example.surveynow.ui.screens.sign_in.SignInUiState

@Composable
fun CreateAccountScreen(
    viewModel: SignInViewModel,
    navController: NavController,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.events.collect { event ->
            when (event) {
                SignInUiEvent.OnFinish -> navController.navigate(Screen.Survey.route)
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
    state: SignInUiState,
    onAction: (SignInUiAction) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        CreateAccount(Modifier.padding(top = 150.dp))
        AccountSetup(
            email = state.email,
            onClick = onAction,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCreateAccountLayout() {
    CreateAccountLayout(state = SignInUiState(), onAction = {})
}