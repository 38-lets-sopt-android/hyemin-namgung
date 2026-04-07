package com.example.letssopt

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.LocalLETSSOPTTypography
import com.example.letssopt.ui.theme.typography
import kotlinx.coroutines.launch


class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                SignUpScreen()
            }
        }
    }
}

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var emailText by remember { mutableStateOf("") }
    var pwText by remember { mutableStateOf("") }
    var confirmPwText by remember { mutableStateOf("") }

    val isButtonEnabled =
        emailText.isNotBlank() && pwText.isNotBlank() && confirmPwText.isNotBlank()

    val typography = LocalLETSSOPTTypography.current
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = LETSSOPTColors.Background)
                .padding(innerPadding)
                .padding(horizontal = 20.dp)

        ) {
            Spacer(Modifier.weight(60f))

            Text(
                text = "watcha",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = typography.logo,
                color = LETSSOPTColors.PrimaryRed
            )

            Spacer(Modifier.weight(26f))

            Text(
                text = "회원가입",
                modifier = Modifier.fillMaxWidth(),
                style = typography.h2,
                color = LETSSOPTColors.TextPrimary
            )

            Spacer(Modifier.weight(36f))

            AuthTextField(
                value = emailText,
                onValueChange = { emailText = it },
                titleText = "이메일",
                placeholder = "이메일 주소를 입력해주세요 (ex.sopt@sopt.org)",
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = pwText,
                onValueChange = { pwText = it },
                titleText = "비밀번호",
                placeholder = "8~12자의 비밀번호를 입력해주세요!"
            )

            Spacer(Modifier.weight(18f))



            AuthTextField(
                value = confirmPwText,
                onValueChange = { confirmPwText = it },
                titleText = "비밀번호 확인",
                placeholder = "비밀번호를 다시 입력해주세요"
            )

            Spacer(Modifier.weight(280f))

            Button(
                onClick = {
                    if (
                        isVerifySignUp(
                            emailText = emailText,
                            pwText = pwText,
                            confirmPwText = confirmPwText
                        )
                    ) {

                    } else {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "이메일 또는 비밀번호 형식이 올바르지 않습니다."
                            )
                        }
                    }
                },
                modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                enabled = isButtonEnabled,
                colors = ButtonDefaults.buttonColors(
                    containerColor = LETSSOPTColors.PrimaryRed,
                    disabledContainerColor = LETSSOPTColors.Disabled,
                    contentColor = LETSSOPTColors.TextPrimary,
                    disabledContentColor = LETSSOPTColors.Placeholder,
                )
            ) {
                Text(
                    text = "회원가입",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 131.dp, top = 17.dp, end = 130.dp, bottom = 16.dp),
                    color = LETSSOPTColors.TextPrimary, // 여기 색상 두가지로 난누깅
                    style = typography.body,
                )
            }

            Spacer(Modifier.weight(26f))
        }
    }
}


@Composable
private fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    titleText: String,
    placeholder: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = titleText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 3.dp),

            style = typography.caption,
            color = LETSSOPTColors.TextSecondary
        )

        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = LETSSOPTColors.Surface,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LETSSOPTColors.Surface,
                unfocusedContainerColor = LETSSOPTColors.Surface,
                disabledContainerColor = LETSSOPTColors.Surface,
                focusedTextColor = LETSSOPTColors.Placeholder,
                unfocusedTextColor = LETSSOPTColors.Placeholder,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedPlaceholderColor = LETSSOPTColors.Surface,
                unfocusedPlaceholderColor = LETSSOPTColors.Surface,
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = typography.caption,
                    color = LETSSOPTColors.Placeholder
                )
            },
            shape = RoundedCornerShape(8.dp)
        )
    }
}

private fun isVerifySignUp(
    emailText: String,
    pwText: String,
    confirmPwText: String
): Boolean {
    val emailRegex =
        Regex("^[A-Za-z0-9](?:[A-Za-z0-9._%+-]*[A-Za-z0-9])?@[A-Za-z0-9](?:[A-Za-z0-9.-]*[A-Za-z0-9])?\\.[A-Za-z]{2,}$")
    val passwordRegex = Regex("^.{8,12}$")

    return emailRegex.matches(emailText) &&
            passwordRegex.matches(pwText) &&
            pwText == confirmPwText
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF141414)
@Composable
private fun TextFieldPreview() {
    LETSSOPTTheme {
        AuthTextField(
            value = "",
            onValueChange = {},
            titleText = "비밀번호 확인 ",
            placeholder = "비밀번호를 다시 입력해주세요",
        )
    }
}
