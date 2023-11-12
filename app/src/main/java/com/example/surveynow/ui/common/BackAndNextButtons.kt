package com.example.surveynow.ui.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.surveynow.R
import com.example.surveynow.ui.screens.survey.SurveyUiAction

@Composable
fun BackAndNextButtons(
    modifier: Modifier = Modifier,
    onNext: (SurveyUiAction) -> Unit,
    onBack: (SurveyUiAction) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FloatingActionButton(
                onClick = { onBack(SurveyUiAction.GoToBestMovie) },
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = Color.White
            ){
                Icon(Icons.Filled.ArrowBack, stringResource(id = R.string.back))
            }

            FloatingActionButton(
                onClick = { onNext(SurveyUiAction.GoToBestFries) },
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = Color.White
            ){
                Icon(Icons.Filled.ArrowForward, stringResource(id = R.string.next))
            }
        }
    }
}