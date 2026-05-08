package com.example.letssopt.presentation.auth.signup

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.core.common.state.UiState
import com.example.letssopt.data.local.UserPreferences
import com.example.letssopt.data.model.SignUpRequestModel
import com.example.letssopt.data.repository.SignUpRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val preferences: UserPreferences,
    private val signUpRepository: SignUpRepository
) : ViewModel() {

    companion object {
        private const val TAG = "SignUpViewModel"

        private val EMAIL_REGEX =
            Regex("^[A-Za-z0-9](?:[A-Za-z0-9._%+-]*[A-Za-z0-9])?@[A-Za-z0-9](?:[A-Za-z0-9.-]*[A-Za-z0-9])?\\.[A-Za-z]{2,}$")
        private val PASSWORD_REGEX = Regex("^.{8,12}$")
    }

    private val _signUpUiState = MutableStateFlow(SignUpUiState())
    val signUpUiState = _signUpUiState.asStateFlow()

    private val _uiState =
        MutableStateFlow<UiState<SignUpUiState>>(UiState.Success(SignUpUiState()))
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SignUpSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun updateLoginId(changeLoginId: String) = updateFormState {
        it.copy(loginId = changeLoginId)
    }

    fun updatePassword(changePassword: String) = updateFormState {
        it.copy(password = changePassword)
    }

    fun updateConfirmPassword(changeConfirmPassword: String) = updateFormState {
        it.copy(confirmPassword = changeConfirmPassword)
    }

    fun updateName(changeName: String) = updateFormState {
        it.copy(name = changeName)
    }

    fun updateEmail(changeEmail: String) = updateFormState {
        it.copy(email = changeEmail)
    }

    fun updateAge(changeAge: String) = updateFormState {
        it.copy(age = changeAge.filter(Char::isDigit))
    }

    fun updatePart(changePart: String) = updateFormState {
        it.copy(part = changePart)
    }

    fun onSignUpClick() {
        viewModelScope.launch {
            val state = _signUpUiState.value
            Log.d(TAG, "onSignUpClick: state=$state")

            if (!isSignUpValid(state)) {
                val message = "입력값을 다시 확인해주세요."
                Log.d(
                    TAG,
                    "validation failed: emailValid=${isEmailValid(state)}, passwordValid=${isPasswordValid(state)}, passwordSame=${isPasswordSame(state)}"
                )
                _uiState.value = UiState.Failure(message)
                _sideEffect.emit(SignUpSideEffect.ShowSnackbar(message))
                return@launch
            }

            _uiState.value = UiState.Loading

            signUpRepository.postSignUp(
                SignUpRequestModel(
                    loginId = state.loginId,
                    password = state.password,
                    name = state.name,
                    email = state.email,
                    age = state.age.toIntOrNull() ?: 0,
                    part = state.part
                )
            ).onSuccess {
                Log.d(TAG, "signUp success: loginId=${state.loginId}")
                saveUserInfo(state)
                _uiState.value = UiState.Success(state)
                _sideEffect.emit(SignUpSideEffect.SignUpSuccess)
            }.onFailure { throwable ->
                val message = throwable.message ?: "회원가입에 실패했습니다."
                Log.e(TAG, "signUp failure", throwable)
                _uiState.value = UiState.Failure(message)
                _sideEffect.emit(SignUpSideEffect.ShowSnackbar(message))
            }
        }
    }

    private fun updateFormState(reducer: (SignUpUiState) -> SignUpUiState) {
        _signUpUiState.update { currentState ->
            reducer(currentState)
        }
        _uiState.value = UiState.Success(_signUpUiState.value)
    }

    private fun isEmailValid(state: SignUpUiState): Boolean = EMAIL_REGEX.matches(state.email)

    private fun isPasswordValid(state: SignUpUiState): Boolean =
        PASSWORD_REGEX.matches(state.password)

    private fun isPasswordSame(state: SignUpUiState): Boolean =
        state.password == state.confirmPassword

    private fun isSignUpValid(state: SignUpUiState): Boolean {
        return listOf(
            state.loginId,
            state.password,
            state.confirmPassword,
            state.name,
            state.email,
            state.age,
            state.part
        ).all { it.isNotBlank() } &&
            isEmailValid(state) &&
            isPasswordValid(state) &&
            isPasswordSame(state)
    }

    private fun saveUserInfo(state: SignUpUiState) {
        preferences.saveUserInfo(email = state.email, password = state.password)
    }
}
