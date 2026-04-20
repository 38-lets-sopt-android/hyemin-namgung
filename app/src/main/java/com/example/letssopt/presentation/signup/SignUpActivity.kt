package com.example.letssopt.presentation.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.designsystem.component.AuthTextField
import com.example.letssopt.designsystem.component.SubmitButton
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import kotlinx.coroutines.launch

class SignUpActivity : ComponentActivity() {
    private val viewModel by viewModels<SignUpViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                SignUpScreen(
                    viewModel = viewModel,
                    onSignUpSuccess = { email, pw ->
                        val resultIntent = Intent().apply {
                            putExtra("registerEmail", email)
                            putExtra("registerPw", pw)
                        }

                        setResult(RESULT_OK, resultIntent)
                        finish()

                    }
                )
            }
        }
    }
}

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel,
    onSignUpSuccess: (String, String) -> Unit,
    modifier: Modifier = Modifier,
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()


    val inputEmail by viewModel.email.collectAsState()
    val inputPassword by viewModel.password.collectAsState()
    val inputConfirmPassword by viewModel.confirmPassword.collectAsState()

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
                .imePadding()

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
                value = inputEmail,
                onValueChange = { viewModel.updateEmail(changeEmail = it) },
                titleText = "이메일",
                placeholder = "이메일 주소를 입력해주세요 (ex.sopt@sopt.org)",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = inputPassword,
                onValueChange = { viewModel.updatePassword(changePassword = it) },
                titleText = "비밀번호",
                placeholder = "8~12자의 비밀번호를 입력해주세요!",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = inputConfirmPassword,
                onValueChange = { viewModel.updateConfirmPassword(changeConfirmPassword = it) },
                titleText = "비밀번호 확인",
                placeholder = "비밀번호를 다시 입력해주세요",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(Modifier.weight(280f))

            SubmitButton(
                text = "회원가입",
                enabled = viewModel.isButtonEnabled(),
                onClick = {
                    if ( //Todo() 나중에 각각 다른 분기처리해서 isError로 변경하기
                       viewModel.isVerifyEmail() && viewModel.isVerifyPassword() && viewModel.isSamePassword()
                    ) {
                        onSignUpSuccess(inputEmail, inputPassword)
                    } else {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "이메일 또는 비밀번호 형식이 올바르지 않습니다."
                            )
                        }
                    }
                }
            )

            Spacer(Modifier.weight(26f))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen(viewModel = SignUpViewModel(), onSignUpSuccess = { _, _ -> })
    }
}
