package com.example.surveynow.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surveynow.R
import com.example.surveynow.ui.theme.PacificaFamily

@Composable
fun CreateAccount(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 44.dp),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.create_account),
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontFamily = PacificaFamily,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCreateAccount() {
    CreateAccount()
}