package com.example.letssopt.presentation.login

import androidx.lifecycle.ViewModel
import com.example.letssopt.local.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel(
    private val preferences: UserPreferences
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()


    fun updateEmail(changeEmail: String) {
        _email.value = changeEmail
    }

    fun updatePassword(changePassword: String) {
        _password.value = changePassword
    }

    fun isValidLogin(): Boolean {
        val savedEmail = preferences.getEmail()
        val savedPassWord = preferences.getPassword()
        return _email.value == savedEmail &&
                _password.value == savedPassWord
    }

    fun setAutoLogin(isLogin: Boolean) {
        preferences.setAutoLogin(isLogin)
    }

    fun getAutoLogin(): Boolean {
        return preferences.getAutoLogin()
    }
}
