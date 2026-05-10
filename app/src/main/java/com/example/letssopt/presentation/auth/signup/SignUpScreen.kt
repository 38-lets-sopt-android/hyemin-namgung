package com.example.letssopt.presentation.auth.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.letssopt.core.common.state.UiState
import com.example.letssopt.core.designsystem.component.AuthDropdownField
import com.example.letssopt.core.designsystem.component.AuthTextField
import com.example.letssopt.core.designsystem.component.SubmitButton
import com.example.letssopt.core.designsystem.theme.LETSSOPTColors
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.core.designsystem.theme.typography
import com.example.letssopt.data.local.UserPreferences
import com.example.letssopt.data.remote.RetrofitClient
import com.example.letssopt.data.remote.datasourceImpl.SignUpDataSourceImpl
import com.example.letssopt.data.repositoryImpl.SignUpRepositoryImpl

private val partOptions = Part.entries.map(Part::string)

@Composable
fun SignUpRoute(
    paddingValues: PaddingValues,
    onNavigateToLogin: () -> Unit,
) {
    val context = LocalContext.current
    val pref = remember { UserPreferences(context) }
    val signUpRepository = remember {
        SignUpRepositoryImpl(
            signUpDataSource = SignUpDataSourceImpl(RetrofitClient.signUpService)
        )
    }
    val factory = remember { SignUpViewModelFactory(pref, signUpRepository) }
    val viewModel: SignUpViewModel = viewModel(factory = factory)

    val uiState by viewModel.uiState.collectAsState()
    val signUpUiState by viewModel.signUpUiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        viewModel.sideEffect.collect { sideEffect ->
            when (sideEffect) {
                is SignUpSideEffect.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(sideEffect.message)
                }

                SignUpSideEffect.SignUpSuccess -> {
                    onNavigateToLogin()
                }
            }
        }
    }

    when (uiState) {
        is UiState.Empty,
        is UiState.Failure,
        is UiState.Success -> {
            SignUpScreen(
                uiState = signUpUiState,
                paddingValues = paddingValues,
                snackbarHostState = snackbarHostState,
                onLoginIdChange = viewModel::updateLoginId,
                onPasswordChange = viewModel::updatePassword,
                onConfirmPasswordChange = viewModel::updateConfirmPassword,
                onNameChange = viewModel::updateName,
                onEmailChange = viewModel::updateEmail,
                onAgeChange = viewModel::updateAge,
                onPartChange = viewModel::updatePart,
                onSignUpClick = viewModel::onSignUpClick
            )
        }

        is UiState.Loading -> {
            Text(text = "Loading...")
        }
    }

}

@Composable
private fun SignUpScreen(
    uiState: SignUpUiState,
    paddingValues: PaddingValues,
    snackbarHostState: SnackbarHostState,
    onLoginIdChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onAgeChange: (String) -> Unit,
    onPartChange: (String) -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = LETSSOPTColors.Background)
                .padding(paddingValues)
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
                .imePadding()

        ) {
            Spacer(Modifier.weight(30f))

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
                value = uiState.loginId,
                onValueChange = onLoginIdChange,
                titleText = "아이디",
                placeholder = "아이디를 입력해주세요",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
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
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = uiState.confirmPassword,
                onValueChange = onConfirmPasswordChange,
                titleText = "비밀번호 확인",
                placeholder = "비밀번호를 다시 입력해주세요",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = uiState.name,
                onValueChange = onNameChange,
                titleText = "이름",
                placeholder = "이름을 입력해주세요",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = uiState.email,
                onValueChange = onEmailChange,
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
                value = uiState.age,
                onValueChange = onAgeChange,
                titleText = "나이",
                placeholder = "나이를 입력해주세요",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.weight(18f))

            AuthDropdownField(
                value = uiState.part,
                onValueChange = onPartChange,
                titleText = "파트",
                placeholder = "파트를 선택해주세요",
                options = partOptions,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.weight(60f))

            SubmitButton(
                text = "회원가입",
                enabled = uiState.isButtonEnabled,
                onClick = onSignUpClick
            )

            Spacer(Modifier.weight(16f))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen(
            uiState = SignUpUiState(
                email = "sopt@sopt.org",
                password = "12345678",
                confirmPassword = "12345678",
                loginId = "soptsopt",
                name = "영크크",
                age = "17",
                part = "안드로이드"
            ),
            paddingValues = PaddingValues(),
            snackbarHostState = SnackbarHostState(),
            onLoginIdChange = {},
            onPasswordChange = {},
            onConfirmPasswordChange = {},
            onNameChange = {},
            onEmailChange = {},
            onAgeChange = {},
            onPartChange = {},
            onSignUpClick = {},
        )
    }
}
