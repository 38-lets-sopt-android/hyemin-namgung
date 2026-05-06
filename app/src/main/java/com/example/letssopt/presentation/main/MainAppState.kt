package com.example.letssopt.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.letssopt.common.navigation.Route
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Stable
class MainAppState(
    val navController: NavHostController,
    val startDestination: Route
) {

    private val _currentTab = MutableStateFlow<NavDestination>(NavDestination.HOME)
    val currentTab: StateFlow<NavDestination> = _currentTab.asStateFlow()

    fun navigate(tab: NavDestination) {
        navController.navigate(tab.route) {
            launchSingleTop = true
            restoreState = true
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
        }
    }
}


@Composable
fun rememberMainAppState(
    navController: NavHostController = rememberNavController(),
    startDestination: Route
): MainAppState {
    return remember(navController, startDestination) {
        MainAppState(navController = navController, startDestination = startDestination)
    }
}
