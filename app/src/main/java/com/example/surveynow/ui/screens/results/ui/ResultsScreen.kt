package com.example.surveynow.ui.screens.results.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.surveynow.R
import com.example.surveynow.ui.screens.results.ResultsUiAction
import com.example.surveynow.ui.screens.results.ResultsUiState
import com.example.surveynow.ui.screens.results.ResultsViewModel

@Composable
fun ResultsScreen(
    viewModel: ResultsViewModel,
    navController: NavController
) {
    val state by viewModel.state.collectAsState()

    ResultsLayout(
        state = state,
        onAction = viewModel::handleAction
    )
}

@Composable
fun ResultsLayout(
    state: ResultsUiState,
    onAction: (ResultsUiAction) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.results))
    }
}
