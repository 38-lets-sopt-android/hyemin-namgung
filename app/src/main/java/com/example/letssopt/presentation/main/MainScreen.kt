package com.example.letssopt.presentation.main

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.finder.Finder
import com.example.letssopt.presentation.finder.FinderScreen
import com.example.letssopt.presentation.home.Home
import com.example.letssopt.presentation.home.HomeScreen
import com.example.letssopt.presentation.main.component.MainBottomBar
import com.example.letssopt.presentation.purchase.Purchase
import com.example.letssopt.presentation.purchase.PurchaseScreen
import com.example.letssopt.presentation.search.Search
import com.example.letssopt.presentation.search.SearchScreen
import com.example.letssopt.presentation.webtoon.Webtoon
import com.example.letssopt.presentation.webtoon.WebtoonScreen
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
            composable<Home> {
                HomeScreen(innerPadding)
            }
            composable<Purchase> {
                PurchaseScreen(innerPadding)
            }
            composable<Webtoon> {
                WebtoonScreen(innerPadding)
            }
            composable<Search> {
                SearchScreen(innerPadding)
            }
            composable<Finder> {
                FinderScreen(innerPadding)
            }

        }
    }


}


@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LETSSOPTTheme {
        val appState = rememberMainAppState()
        MainScreen(appState = appState)
    }
}
