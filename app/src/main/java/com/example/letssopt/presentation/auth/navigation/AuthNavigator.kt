package com.example.letssopt.presentation.auth.navigation

import android.widget.Toast
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.letssopt.common.navigation.Route
import com.example.letssopt.presentation.auth.login.LoginRoute
import com.example.letssopt.presentation.auth.login.navigation.Login
import com.example.letssopt.presentation.auth.signup.SignUpRoute
import com.example.letssopt.presentation.auth.signup.navigation.SignUp
import com.example.letssopt.presentation.home.navigation.Home
import kotlinx.serialization.Serializable

@Serializable
data object Auth : Route

fun NavGraphBuilder.authNavGraph(
    paddingValues: PaddingValues,
    navController: NavController,
) {
    navigation<Auth>(
        startDestination = Login
    )
    {
        composable<Login> {
            val context = LocalContext.current

            LoginRoute(
                paddingValues = paddingValues,
                onNavigateToSignUp = {
                    navController.navigate(SignUp)
                },
                onLoginSuccess = {
                    navController.navigate(Home) {
                        popUpTo(Auth) { inclusive = true }
                    }
                },
                onLoginFailure = { message ->
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                }
            )
        }

        composable<SignUp> {
            SignUpRoute(
                paddingValues = paddingValues,
                onNavigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
    }
}
