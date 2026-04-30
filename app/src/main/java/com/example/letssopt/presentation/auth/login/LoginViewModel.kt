package com.example.letssopt.presentation.auth.login

import androidx.lifecycle.ViewModel
import com.example.letssopt.local.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel(
    private val preferences: UserPreferences
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

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

    fun isValidLogin(): Boolean {
        val state = _uiState.value

        return preferences.getEmail() == state.email &&
                preferences.getPassword() == state.password
    }

    fun setAutoLogin(isLogin: Boolean) {
        preferences.setAutoLogin(isLogin)
    }

    fun getAutoLogin(): Boolean {
        return preferences.getAutoLogin()
    }
}
