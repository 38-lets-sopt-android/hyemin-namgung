package com.example.letssopt.presentation.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.letssopt.local.UserPreferences
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val preferences: UserPreferences
) : ViewModel() {

    companion object {
        private val EMAIL_REGEX =
            Regex("^[A-Za-z0-9](?:[A-Za-z0-9._%+-]*[A-Za-z0-9])?@[A-Za-z0-9](?:[A-Za-z0-9.-]*[A-Za-z0-9])?\\.[A-Za-z]{2,}$")
        private val PASSWORD_REGEX = Regex("^.{8,12}$")
    }

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<SignUpSideEffect>()
    val sideEffect: SharedFlow<SignUpSideEffect> = _sideEffect.asSharedFlow()

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

    fun updateConfirmPassword(changeConfirmPassword: String) {
        _uiState.update {
            it.copy(confirmPassword = changeConfirmPassword)
        }
    }

    fun onSignUpClick() {
        viewModelScope.launch {
            
            if (isSignUpValid()) {
                saveUserInfo()
                _sideEffect.emit(
                    SignUpSideEffect.SignUpSuccess
                )

            } else {
                _sideEffect.emit(
                    SignUpSideEffect.ShowSnackbar(message = "이메일 또는 비번이 틀렸습니다!")
                )
            }
        }
    }

    private fun isEmailValid(): Boolean {
        return EMAIL_REGEX.matches(_uiState.value.email)
    }

    private fun isPasswordValid(): Boolean {
        return PASSWORD_REGEX.matches(_uiState.value.password)
    }

    private fun isPasswordSame(): Boolean {
        return _uiState.value.password == _uiState.value.confirmPassword
    }

    private fun isSignUpValid(): Boolean {
        return isEmailValid() && isPasswordValid() && isPasswordSame()
    }

    private fun saveUserInfo() {
        preferences.saveUserInfo(email = _uiState.value.email, password = _uiState.value.password)
    }

}
