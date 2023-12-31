@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.surveynow.ui.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.surveynow.R
import com.example.surveynow.ui.screens.sign_in.SignInUiAction
import com.example.surveynow.ui.theme.MontserratFamily
import com.example.surveynow.util.cleanString


@Composable
fun AccountSetup(
    email: String,
    onClick: (SignInUiAction) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isNameUpdated by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column {
            TextField(
                value = email,
                onValueChange = {},
                enabled = false,
                readOnly = true,
                label = {
                    Text(
                        text = stringResource(id = R.string.email_address),
                        fontFamily = MontserratFamily
                    )
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                textStyle = TextStyle(
                    fontFamily = MontserratFamily
                )
            )
            TextField(
                value = name,
                onValueChange = {
                    name = it.also { it.text.cleanString() }
                    isNameUpdated = name.text.isNotEmpty()
                },
                label = {
                    Text(
                        text = stringResource(id = R.string.name),
                        fontFamily = MontserratFamily
                    )
                },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp),
                textStyle = TextStyle(
                    fontFamily = MontserratFamily
                )
            )
            Button(
                onClick = { onClick(SignInUiAction.OnFinish(name.text)) },
                enabled = isNameUpdated,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.finish),
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
fun PreviewAccountSetUp() {
    AccountSetup("email@address.com", {})
}