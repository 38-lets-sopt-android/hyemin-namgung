package com.example.letssopt.presentation.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class LoginViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private var registerEmail: String = ""
    private var registerPassword: String = ""

    fun updateEmail(changeEmail: String) {
        _email.value = changeEmail
    }

    fun updatePassword(changePassword: String) {
        _password.value = changePassword
    }

    fun updateRegisterUser(changeEmail: String, changePassword: String) {
        registerEmail = changeEmail
        registerPassword = changePassword
    }

    fun login(
        registerEmail: String,
        registerPassword: String
    )
            : Boolean {
        return _email.value == registerEmail &&
                _password.value == registerPassword
    }
}
