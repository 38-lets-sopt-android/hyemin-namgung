package com.example.letssopt.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.common.navigation.MainTabRoute
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.component.HomeTopBar
import com.example.letssopt.presentation.home.component.NewContentSection
import com.example.letssopt.presentation.home.component.UpcomingSection
import com.example.letssopt.presentation.home.component.WatchaPartySection
import com.example.letssopt.presentation.home.component.WatgorithmSection
import com.example.letssopt.presentation.home.model.WatchaPartyModel
import kotlinx.serialization.Serializable

@Serializable
data object Home : MainTabRoute

@Composable
fun HomeScreen(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier,
    onTopBarActionClick: () -> Unit = {},
    onNewContentClick: () -> Unit = {},
    onWatgorithmContentClick: () -> Unit = {},
    onWatgorithmMoreClick: () -> Unit = {},
    onUpcomingContentClick: () -> Unit = {},
    onUpcomingMoreClick: () -> Unit = {},
    onWatchaPartyClick: (WatchaPartyModel) -> Unit = {},
    onWatchaPartyAlarmClick: (WatchaPartyModel) -> Unit = {},
    onWatchaPartyMoreClick: () -> Unit = {},
) {
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding),
        containerColor = LETSSOPTColors.Background,
        topBar = {
            HomeTopBar(
                onActionClick = onTopBarActionClick
            )
        }
    ) { scaffoldPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding),
            verticalArrangement = Arrangement.spacedBy(32.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            item(key = "new_content") {
                NewContentSection(
                    contents = HomeFakeData.newContentsData,
                    onContentClick = onNewContentClick
                )
            }

            item(key = "watgorithm") {
                WatgorithmSection(
                    contents = HomeFakeData.watgorithmData,
                    onContentClick = onWatgorithmContentClick,
                    onMoreClick = onWatgorithmMoreClick
                )
            }

            item(key = "upcoming") {
                UpcomingSection(
                    contents = HomeFakeData.upcomingContentData,
                    onContentClick = onUpcomingContentClick,
                    onMoreClick = onUpcomingMoreClick
                )
            }
            item(key = "watcha_party") {
                WatchaPartySection(
                    parties = HomeFakeData.watchaPartyData,
                    onPartyClick = onWatchaPartyClick,
                    onAlarmClick = onWatchaPartyAlarmClick,
                    onMoreClick = onWatchaPartyMoreClick
                )
            }

        }

    }

}

@Preview
@Composable
private fun HomeScreenPreview() {
    LETSSOPTTheme {
        HomeScreen(innerPadding = PaddingValues(10.dp))
    }
}
