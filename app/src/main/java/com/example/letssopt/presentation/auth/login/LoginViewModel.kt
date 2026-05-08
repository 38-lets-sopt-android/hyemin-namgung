package com.example.letssopt.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.core.common.state.UiState
import com.example.letssopt.data.local.UserPreferences
import com.example.letssopt.data.model.SignInRequestModel
import com.example.letssopt.data.repository.SignInRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val preferences: UserPreferences,
    private val signInRepository: SignInRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow<UiState<LoginUiState>>(UiState.Success(LoginUiState()))
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<LoginSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun updateLoginId(changeLoginId: String) {
        val currentState = currentLoginUiState()
        _uiState.value = UiState.Success(currentState.copy(loginId = changeLoginId))
    }

    fun updatePassword(changePassword: String) {
        val currentState = currentLoginUiState()
        _uiState.value = UiState.Success(currentState.copy(password = changePassword))
    }

    fun onLoginClick() {
        viewModelScope.launch {
            val state = currentLoginUiState()
            _uiState.value = UiState.Loading

            signInRepository.postSignIn(
                SignInRequestModel(
                    loginId = state.loginId,
                    password = state.password
                )
            ).onSuccess {
                preferences.setAutoLogin(true)
                _uiState.value = UiState.Success(state)
                _sideEffect.emit(LoginSideEffect.LoginSuccess)
            }.onFailure { throwable ->
                _uiState.value = UiState.Failure(
                    throwable.message ?: "로그인에 실패했습니다."
                )
                _sideEffect.emit(
                    LoginSideEffect.ShowToastMessage(
                        throwable.message ?: "로그인에 실패했습니다."
                    )
                )
            }
        }
    }

    private fun currentLoginUiState(): LoginUiState =
        when (val state = _uiState.value) {
            is UiState.Success -> state.data
            else -> LoginUiState()
        }
}
