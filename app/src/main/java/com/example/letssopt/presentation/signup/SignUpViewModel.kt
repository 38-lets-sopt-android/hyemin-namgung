package com.example.letssopt.presentation.signup

import androidx.lifecycle.ViewModel
import com.example.letssopt.local.UserPreferences
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SignUpViewModel(
    private val preferences: UserPreferences
) : ViewModel() {
    private val _email = MutableStateFlow("")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password = _password.asStateFlow()

    private val _confirmPassword = MutableStateFlow("")
    val confirmPassword = _confirmPassword.asStateFlow()


    fun updateEmail(changeEmail: String) {
        _email.value = changeEmail
    }

    fun updatePassword(changePassword: String) {
        _password.value = changePassword
    }

    fun updateConfirmPassword(changeConfirmPassword: String) {
        _confirmPassword.value = changeConfirmPassword
    }

    fun isButtonEnabled(): Boolean {
        return _email.value.isNotBlank() && _password.value.isNotBlank() && _confirmPassword.value.isNotBlank()
    }

    fun isVerifyEmail(): Boolean {
        val emailRegex =
            Regex("^[A-Za-z0-9](?:[A-Za-z0-9._%+-]*[A-Za-z0-9])?@[A-Za-z0-9](?:[A-Za-z0-9.-]*[A-Za-z0-9])?\\.[A-Za-z]{2,}$")
        return emailRegex.matches(_email.value)
    }

    fun isVerifyPassword(): Boolean {
        val passwordRegex = Regex("^.{8,12}$")

        return passwordRegex.matches(_password.value)
    }

    fun isSamePassword(): Boolean {
        return _password.value == _confirmPassword.value
    }

    fun isValidSignUp(): Boolean {
        return isVerifyEmail() && isVerifyPassword() && isSamePassword()
    }

    fun saveUserInfo() {
        preferences.saveUserInfo(_email.value, _password.value)
    }

}
