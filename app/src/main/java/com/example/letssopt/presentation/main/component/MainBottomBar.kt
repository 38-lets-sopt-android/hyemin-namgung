package com.example.letssopt.presentation.main.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.presentation.home.navigation.Home
import com.example.letssopt.presentation.main.MainAppState
import com.example.letssopt.presentation.main.NavDestination
import com.example.letssopt.presentation.main.rememberMainAppState

@Composable
fun MainBottomBar(
    appState: MainAppState,
    modifier: Modifier = Modifier
) {
    val navBackStackEntry by appState.navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(vertical = 11.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavDestination.entries.forEach { tab ->
            key(tab.route) {
                MainBottomBarItem(
                    tab = tab,
                    selected = currentDestination?.hasRoute(tab.route::class) == true,
                    onClick = { appState.navigate(tab) }
                )
            }

        }
    }
}

@Composable
private fun RowScope.MainBottomBarItem(
    tab: NavDestination,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .weight(1f)
            .noRippleClickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(7.dp)
    ) {

        Icon(
            imageVector = ImageVector.vectorResource(id = tab.iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = if (selected) LETSSOPTColors.TextPrimary else LETSSOPTColors.Disabled,
        )

        Text(
            text = tab.label,
            color = if (selected) LETSSOPTColors.TextPrimary else LETSSOPTColors.Disabled,
            style = typography.body2
        )

    }
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun MainBottomBarPreview() {
    LETSSOPTTheme {
        val appState = rememberMainAppState(startDestination = Home)
        MainBottomBar(appState = appState)
    }
}
