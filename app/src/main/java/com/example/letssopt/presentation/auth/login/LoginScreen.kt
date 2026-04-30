package com.example.letssopt.presentation.auth.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.component.AuthTextField
import com.example.letssopt.designsystem.component.SubmitButton
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.local.UserPreferences

@Composable
fun LoginRoute(
    paddingValues: PaddingValues,
    onNavigateToSignUp: () -> Unit,
    onLoginSuccess: () -> Unit,
    onLoginFailure: (String) -> Unit
) {
    val context = LocalContext.current
    val pref = remember {  UserPreferences(context)}
    val factory = remember { LoginViewModelFactory(pref) }
    val viewModel : LoginViewModel = viewModel(factory = factory)

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when(sideEffect){
                LoginSideEffect.LoginSuccess -> onLoginSuccess()
                is LoginSideEffect.ShowToastMessage -> onLoginFailure(sideEffect.message)
            }
        }
    }
    LoginScreen(
        uiState = uiState,
        paddingValues = paddingValues,
        onEmailChange = viewModel::updateEmail,
        onPasswordChange = viewModel::updatePassword,
        onSignInClick = viewModel::onLoginClick,
        onSignUpClick = onNavigateToSignUp,
    )

}

@Composable
private fun LoginScreen(
    uiState: LoginUiState,
    paddingValues: PaddingValues,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = LETSSOPTColors.Background)
                .padding(paddingValues)
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
                text = "이메일로 로그인",
                modifier = Modifier.fillMaxWidth(),
                style = typography.h2,
                color = LETSSOPTColors.TextPrimary
            )

            Spacer(Modifier.weight(36f))

            AuthTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
                titleText = "이메일",
                placeholder = "이메일 주소를 입력해주세요 (ex.sopt@sopt.org)",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next, keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = uiState.password,
                onValueChange = onPasswordChange,
                titleText = "비밀번호",
                placeholder = "8~12자의 비밀번호를 입력해주세요!",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(Modifier.weight(333f))

            Text(
                text = "아직 계정이 없으신가요? 회원가입",
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable(
                        onClick = onSignUpClick,
                    ),
                style = typography.caption,
                color = LETSSOPTColors.TextSecondary,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(Modifier.weight(20f))

            SubmitButton(
                text = "로그인",
                enabled = uiState.isLoginButtonEnabled,
                onClick = onSignInClick
            )

            Spacer(Modifier.weight(26f))

        }

}

@Preview
@Composable
private fun LoginScreenPreview() {
    LETSSOPTTheme {
        LoginScreen(
            uiState = LoginUiState(
                email = "sopt@sopt.org",
                password = "12345678"
            ),
            paddingValues = PaddingValues(),
            onEmailChange = {},
            onPasswordChange = {},
            onSignInClick = {},
            onSignUpClick = {}
        )
    }
}
