package com.example.surveynow.ui.screens.survey.questions.best_comedy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.surveynow.R
import com.example.surveynow.ui.common.BackAndNextButtons
import com.example.surveynow.ui.screens.survey.SurveyUiAction
import com.example.surveynow.ui.screens.survey.SurveyUiState

@Composable
fun BestMovieScreen(
    state: SurveyUiState,
    onAction: (SurveyUiAction) -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.title_best_movie))
        BackAndNextButtons(
            onNext = { onAction(SurveyUiAction.GoToBestFries) },
            onBack = {}
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewBestMovieScreen() {
    BestMovieScreen(state = SurveyUiState(), onAction = {})
}