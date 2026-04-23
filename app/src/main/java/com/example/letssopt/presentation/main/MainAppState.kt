package com.example.letssopt.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Stable
class MainAppState(
    val navController: NavHostController
) {
    val startDestination = MainTab.HONE.route

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
    navController : NavHostController = rememberNavController()
): MainAppState{
    return remember(navController){
        MainAppState(navController)
    }
}
