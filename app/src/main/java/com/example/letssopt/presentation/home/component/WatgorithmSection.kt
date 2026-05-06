package com.example.letssopt.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.component.ContentPosterCard
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList


@Composable
fun WatgorithmSection(
    contents: ImmutableList<ContentItemModel>,
    onContentClick: () -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {

        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_watgorithm),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp),
            tint = LETSSOPTColors.TextPrimary
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "예능부터 드라마까지!",
                modifier = Modifier.weight(1f),
                color = LETSSOPTColors.TextSecondary,
                style = typography.h3
            )

            Text(
                text = "더보기",
                modifier = Modifier.noRippleClickable(onClick = onMoreClick),
                color = LETSSOPTColors.TextSecondary,
                style = typography.caption1
            )
        }

        Spacer(modifier = Modifier.height(6.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                start = 8.dp
            )
        ) {
            items(
                items = contents,
                key = { it.id }
            ) { item ->
                ContentPosterCard(
                    item = item,
                    onContentClick = onContentClick,
                    modifier = Modifier.width(100.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun WatgorithmSectionPreview(
) {
    LETSSOPTTheme {
        WatgorithmSection(
            contents = HomeFakeData.watgorithmData,
            onContentClick = {}, onMoreClick = {}
        )
    }
}
