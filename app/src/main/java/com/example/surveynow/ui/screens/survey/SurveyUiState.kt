package com.example.surveynow.ui.screens.survey

import androidx.annotation.StringRes
import com.example.surveynow.R

data class SurveyUiState(
    val screenState: ScreenState = ScreenState.Loading
)

sealed class SurveyUiEvent {
    object GoToResults: SurveyUiEvent()
}
sealed class SurveyUiAction {
    object GoToBestMovie: SurveyUiAction()
    object GoToBestFries: SurveyUiAction()
    object GoToFavoriteHoliday: SurveyUiAction()
    object GoToResults: SurveyUiAction()
}

object SurveyConstants {
    const val BEST_COMEDY_MOVIE: String = "Best Comedy Movie"
    const val BEST_FRIES: String = "Best Fries"
    const val FAVORITE_HOLIDAY: String = "Best Holiday"
}

sealed class ScreenState {
    object Loading: ScreenState()
    data class BestMovie(
        val currentScreen: String = SurveyConstants.BEST_COMEDY_MOVIE,
        val questionIndex: Int = 1,
    ): ScreenState()
    data class BestFries(
        val currentScreen: String = SurveyConstants.BEST_FRIES,
        val questionIndex: Int = 2,
    ): ScreenState()
    data class FavoriteHoliday(
        val currentScreen: String = SurveyConstants.FAVORITE_HOLIDAY,
        val questionIndex: Int = 3,
    ): ScreenState()
}

