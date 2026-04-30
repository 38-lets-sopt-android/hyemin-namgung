package com.example.letssopt.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.local.UserPreferences
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val preferences: UserPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<LoginSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

    fun updateEmail(changeEmail: String) {
        _uiState.update {
            it.copy(email = changeEmail)
        }
    }

    fun updatePassword(changePassword: String) {
        _uiState.update {
            it.copy(password = changePassword)
        }
    }

    private fun isValidLogin(): Boolean {
        val state = _uiState.value

        return preferences.getEmail() == state.email &&
                preferences.getPassword() == state.password
    }

    fun onLoginClick() {
        viewModelScope.launch {
            val state = _uiState.value
            if (isValidLogin()) {
                preferences.setAutoLogin(true)
                _sideEffect.emit(LoginSideEffect.LoginSuccess)
            } else {
                _sideEffect.emit(
                    LoginSideEffect.ShowToastMessage("이메일 또는 비밀번호를 확인해주세요")
                )
            }
        }
    }
}
