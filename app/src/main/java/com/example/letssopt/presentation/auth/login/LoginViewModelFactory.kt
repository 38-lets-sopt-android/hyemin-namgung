package com.example.letssopt.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.local.UserPreferences

class LoginViewModelFactory(
    private val preferences: UserPreferences
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(preferences) as T
        }

        throw IllegalArgumentException("LoginViewModel Class is Not Found")
    }
}
