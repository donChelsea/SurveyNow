package com.example.surveynow.ui.screens.sign_in

import androidx.lifecycle.viewModelScope
import com.example.surveynow.ui.SurveyNowViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignInViewModel: SurveyNowViewModel<SignInUiState, SignInUiEvent, SignInUiAction>() {
    private val _state: MutableStateFlow<SignInUiState> = MutableStateFlow(SignInUiState())
    override val state: StateFlow<SignInUiState>
        get() = _state.asStateFlow()

    override fun handleAction(action: SignInUiAction) {
        when (action) {
            is SignInUiAction.OnContinueClicked -> {
                _state.update { it.copy(email = action.email) }
                emitUiEvent(SignInUiEvent.OnContinueClicked)
            }
            SignInUiAction.OnSignInAsGuestClicked -> viewModelScope.launch { _events.emit(SignInUiEvent.OnSignInAsGuest) }
            is SignInUiAction.OnFinish -> _state.update { it.copy(name = action.name) }
        }
    }
}

data class SignInUiState(
    val email: String = "",
    val name: String = "",
)

sealed class SignInUiEvent {
    object OnContinueClicked: SignInUiEvent()
    object OnSignInAsGuest: SignInUiEvent()
    object OnFinish: SignInUiEvent()

}
sealed class SignInUiAction {
    data class OnFinish(val name: String): SignInUiAction()
    data class  OnContinueClicked(val email: String): SignInUiAction()
    object OnSignInAsGuestClicked: SignInUiAction()
}