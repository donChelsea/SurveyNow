package com.example.surveynow.ui.screens.survey

import androidx.lifecycle.viewModelScope
import com.example.surveynow.ui.SurveyNowViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SurveyViewModel : SurveyNowViewModel<SurveyUiState, SurveyUiEvent, SurveyUiAction>() {
    private val _state: MutableStateFlow<SurveyUiState>
    override val state: StateFlow<SurveyUiState>
        get() = _state.asStateFlow()

    init {
        _state = MutableStateFlow(SurveyUiState(
            screenState = ScreenState.BestMovie()
        ))
    }

    override fun handleAction(action: SurveyUiAction) {
        when (action) {
            SurveyUiAction.GoToBestFries -> _state.update { it.copy(screenState = ScreenState.BestFries()) }
            SurveyUiAction.GoToFavoriteHoliday -> _state.update { it.copy(screenState = ScreenState.FavoriteHoliday()) }
            SurveyUiAction.GoToResults -> viewModelScope.launch { _events.emit(SurveyUiEvent.GoToResults) }
            SurveyUiAction.GoToBestMovie -> _state.update { it.copy(screenState = ScreenState.BestMovie()) }
        }
    }
}

