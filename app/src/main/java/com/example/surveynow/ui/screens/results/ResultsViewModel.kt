package com.example.surveynow.ui.screens.results

import com.example.surveynow.ui.SurveyNowViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ResultsViewModel: SurveyNowViewModel<ResultsUiState, ResultsUiEvent, ResultsUiAction>() {
    private val _state: MutableStateFlow<ResultsUiState> = MutableStateFlow(ResultsUiState())
    override val state: StateFlow<ResultsUiState>
        get() = _state.asStateFlow()

    override fun handleAction(action: ResultsUiAction) {

    }
}

data class ResultsUiState(
    val email: String = "",
    val name: String = "",
)

sealed class ResultsUiEvent {}
sealed class ResultsUiAction {}