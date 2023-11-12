@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.surveynow.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.surveynow.R
import com.example.surveynow.ui.screens.sign_in.SignInUiAction
import com.example.surveynow.ui.theme.MontserratFamily
import com.example.surveynow.util.isValidEmail

@Composable
fun SignInSection(
    onClick: (SignInUiAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isEmailUpdated by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = modifier
            .padding(bottom = 24.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            Text(
                text = stringResource(id = R.string.sign_in_or_create),
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = MontserratFamily
                )
            )
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    isEmailUpdated = isValidEmail(email.text) && email.text.isNotEmpty()
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.email_address),
                        fontFamily = MontserratFamily
                    )
                },
                shape = RoundedCornerShape(8.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                textStyle = TextStyle(
                    fontFamily = MontserratFamily
                )
            )
            Button(
                onClick = { onClick(SignInUiAction.OnContinueClicked(email.text)) },
                enabled = isEmailUpdated,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.continue_text),
                    style = TextStyle(
                        fontFamily = MontserratFamily
                    )
                )
            }
            Text(
                text = stringResource(id = R.string.or),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp),
                style = TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = MontserratFamily
                )
            )
            OutlinedButton(
                onClick = { onClick(SignInUiAction.OnSignInAsGuestClicked) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 18.dp, start = 16.dp, end = 16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.sign_in_as_guest),
                    style = TextStyle(
                        fontFamily = MontserratFamily
                    )
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSignIn() {
    SignInSection(onClick = {})
}