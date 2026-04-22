package com.example.letssopt.presentation.home.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

@Composable
fun HomeTopBar(
    actions: ImmutableList<HomeAction>,
    onActionClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 23.dp),
        horizontalArrangement = Arrangement.spacedBy(
            alignment = Alignment.End,
            space = 14.dp,
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        actions.forEach { action ->
            Icon(
                imageVector = ImageVector.vectorResource(id = action.iconRes),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .noRippleClickable(
                        onClick = {onActionClick}
                    ),
                tint = LETSSOPTColors.TextPrimary
            )
        }
    }
}

enum class HomeAction(
    @DrawableRes val iconRes: Int,
) {
    WATCH(
        iconRes = R.drawable.ic_watch,
    ),

    NOTIFICATION(
        iconRes = R.drawable.ic_alram,
    ),

    PROFILE(
        iconRes = R.drawable.ic_profile,
    ),
}

@Preview(showBackground = true, backgroundColor = 0xFF000000)
@Composable
private fun HomeTopBarPreview() {
    HomeTopBar(
        actions = persistentListOf(
            HomeAction.WATCH,
            HomeAction.NOTIFICATION,
            HomeAction.PROFILE
        ),
        onActionClick = {}
    )

}
