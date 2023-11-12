package com.example.surveynow.ui.screens.survey.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.surveynow.ui.common.BackAndNextButtons
import com.example.surveynow.ui.common.LoadingScreen
import com.example.surveynow.ui.navigation.Screen
import com.example.surveynow.ui.screens.survey.ScreenState
import com.example.surveynow.ui.screens.survey.SurveyUiAction
import com.example.surveynow.ui.screens.survey.SurveyUiEvent
import com.example.surveynow.ui.screens.survey.SurveyUiState
import com.example.surveynow.ui.screens.survey.SurveyViewModel
import com.example.surveynow.ui.screens.survey.questions.best_comedy.BestMovieScreen
import com.example.surveynow.ui.screens.survey.questions.best_fries.BestFriesScreen
import com.example.surveynow.ui.screens.survey.questions.favorite_holiday.FavoriteHolidayScreen
import kotlinx.coroutines.flow.collectLatest

@Composable
fun SurveyScreen(
    viewModel: SurveyViewModel,
    navController: NavController,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.events.collectLatest { event ->
            when (event) {
                SurveyUiEvent.GoToResults -> navController.navigate(Screen.Results.route)
            }
        }
    }

    SurveyLayout(
        state = state,
        onAction = viewModel::handleAction
    )
}

@Composable
fun SurveyLayout(
    state: SurveyUiState,
    onAction: (SurveyUiAction) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        when (state.screenState) {
            ScreenState.Loading -> LoadingScreen()

            is ScreenState.BestMovie -> {
                BestMovieScreen(
                    state = state,
                    onAction = onAction
                )
            }

            is ScreenState.BestFries -> {
                BestFriesScreen(
                    state = state,
                    onAction = onAction
                )
            }

            is ScreenState.FavoriteHoliday -> {
                FavoriteHolidayScreen(
                    state = state,
                    onAction = onAction
                )
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewBackAndNextButtons() {
    BackAndNextButtons(onNext = {}) {}
}