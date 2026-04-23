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
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.key
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.LETSSOPTTypography
import com.example.letssopt.designsystem.theme.typography
import kotlinx.collections.immutable.ImmutableList
import com.example.letssopt.presentation.main.MainTab
import kotlinx.collections.immutable.toPersistentList

@Composable
fun MainBottomBar(
    tabs: ImmutableList<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(vertical = 11.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEach { tab ->
            key(tab.route) {
                MainBottomBarItem(
                    tab = tab,
                    selected = (tab == currentTab),
                    onClick = { onTabSelected(tab) }
                )
            }

        }
    }
}

@Composable
private fun RowScope.MainBottomBarItem(
    tab: MainTab,
    selected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
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
        MainBottomBar(
            tabs = MainTab.entries.toList().toPersistentList(),
            currentTab = MainTab.HONE,
            onTabSelected = {}
        )
    }
}
