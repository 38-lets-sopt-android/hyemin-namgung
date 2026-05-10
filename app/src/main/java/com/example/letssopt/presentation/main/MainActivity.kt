package com.example.letssopt.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.letssopt.core.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.data.local.UserPreferences
import com.example.letssopt.presentation.auth.navigation.Auth
import com.example.letssopt.presentation.home.navigation.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        val pref = UserPreferences(this)
//        val startDestination = if (pref.getAutoLogin()) Home else Auth
        val startDestination = Auth

        setContent {
            LETSSOPTTheme {
                val appState = rememberMainAppState(
                    startDestination = startDestination
                )
                MainScreen(appState = appState)
            }
        }
    }
}
