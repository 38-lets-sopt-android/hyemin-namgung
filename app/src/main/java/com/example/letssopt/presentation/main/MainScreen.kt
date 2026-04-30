package com.example.letssopt.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.auth.navigation.authNavGraph
import com.example.letssopt.presentation.finder.navigation.finderNavGraph
import com.example.letssopt.presentation.home.navigation.Home
import com.example.letssopt.presentation.home.navigation.homeNavFGraph
import com.example.letssopt.presentation.main.component.MainBottomBar
import com.example.letssopt.presentation.purchase.navigation.purchaseNavGraph
import com.example.letssopt.presentation.search.navigation.searchNavGraph
import com.example.letssopt.presentation.webtoon.navigation.webtoonNavGraph
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainScreen(appState: MainAppState) {
    val currentTab by appState.currentTab.collectAsState()
    Scaffold(
        bottomBar = {
            MainBottomBar(
                tabs = MainTab.entries.toPersistentList(),
                currentTab = currentTab,
                onTabSelected = { tab ->
                    appState.navigate(tab)
                }
            )
        }
    ) {
        innerPadding ->
        NavHost(
            navController = appState.navController,
            startDestination = appState.startDestination,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = { ExitTransition.None }
        ) {
            finderNavGraph(paddingValues = innerPadding)

            homeNavFGraph(paddingValues = innerPadding )

            purchaseNavGraph(paddingValues = innerPadding)

            searchNavGraph(paddingValues = innerPadding)

            webtoonNavGraph(paddingValues = innerPadding)

            authNavGraph(
                paddingValues = innerPadding,
                navController = appState.navController,
                )
        }
    }


}


@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LETSSOPTTheme {
        val appState = rememberMainAppState(
            startDestination = Home
        )
        MainScreen(appState = appState)
    }
}
