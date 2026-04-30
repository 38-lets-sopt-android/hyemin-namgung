package com.example.letssopt.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.common.navigation.Route
import com.example.letssopt.local.UserPreferences
import com.example.letssopt.presentation.auth.login.navigation.Login
import com.example.letssopt.presentation.auth.navigation.Auth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Stable
class MainAppState(
    val navController: NavHostController,
    val startDestination: Route
) {

    private val _currentTab = MutableStateFlow<MainTab>(MainTab.HONE)
    val currentTab: StateFlow<MainTab> = _currentTab.asStateFlow()

    fun navigate(tab: MainTab) {
        _currentTab.value = tab

        navController.navigate(tab.route) {
            launchSingleTop = true
            restoreState = true
            popUpTo(
                navController.graph.startDestinationId
            ) {
                saveState = true
            }
        }
    }
}

@Composable
fun rememberMainAppState(
    navController : NavHostController = rememberNavController(),
    startDestination: Route
): MainAppState{
    return remember(navController,startDestination){
        MainAppState(navController= navController,startDestination = startDestination)
    }
}
