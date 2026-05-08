package com.example.letssopt.presentation.auth.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.letssopt.data.local.UserPreferences
import com.example.letssopt.data.repository.SignUpRepository

class SignUpViewModelFactory(
    private val preferences: UserPreferences,
    private val signUpRepository: SignUpRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java))
            return SignUpViewModel(preferences, signUpRepository) as T
      throw IllegalArgumentException("ViewModel class not found")
    }
}
