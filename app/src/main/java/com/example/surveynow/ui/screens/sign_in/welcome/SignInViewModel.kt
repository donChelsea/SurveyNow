package com.example.surveynow.ui.screens.welcome

import com.example.surveynow.ui.SurveyNowViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WelcomeViewModel: SurveyNowViewModel<WelcomeUiState, WelcomeUiEvent, WelcomeUiAction>() {
    private val _state: MutableStateFlow<WelcomeUiState> = MutableStateFlow(WelcomeUiState())
    override val state: StateFlow<WelcomeUiState>
        get() = _state.asStateFlow()

    override fun handleAction(action: WelcomeUiAction) {
        when (action) {
            is WelcomeUiAction.OnContinueClicked -> {
                _state.update { it.copy(email = action.email) }
                emitUiEvent(WelcomeUiEvent.OnContinueClicked)
            }
            WelcomeUiAction.OnSignInAsGuestClicked -> {}
            is WelcomeUiAction.OnFinish -> _state.update { it.copy(name = action.name) }
        }
    }
}

data class WelcomeUiState(
    val email: String = "",
    val name: String = "",
)

sealed class WelcomeUiEvent {
    object OnContinueClicked: WelcomeUiEvent()
    object OnSignInAsGuest: WelcomeUiEvent()
    object OnFinish: WelcomeUiEvent()

}
sealed class WelcomeUiAction {
    data class OnFinish(val name: String): WelcomeUiAction()
    data class  OnContinueClicked(val email: String): WelcomeUiAction()
    object OnSignInAsGuestClicked: WelcomeUiAction()
}