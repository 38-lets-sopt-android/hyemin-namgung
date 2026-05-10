package com.example.letssopt.presentation.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.data.local.UserPreferences
import com.example.letssopt.data.repository.SignInRepository

class LoginViewModelFactory(
    private val preferences: UserPreferences,
    private val signInRepository: SignInRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(preferences, signInRepository) as T
        }

        throw IllegalArgumentException("LoginViewModel Class is Not Found")
    }
}
