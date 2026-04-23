package com.example.letssopt.presentation.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.component.ContentPosterCard
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList


@Composable
fun UpcomingSection(
    contents: ImmutableList<ContentItemModel>,
    onContentClick: () -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {

        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp,bottom = 6.dp)
        ) {
            Text(
                text = "공개 예정 콘텐츠",
                modifier = Modifier.weight(1f),
                color = LETSSOPTColors.TextPrimary,
                style = typography.h3
            )

            Text(
                text = "더보기",
                modifier= Modifier.noRippleClickable(onClick = { onMoreClick }),
                color = LETSSOPTColors.TextSecondary,
                style = typography.caption1

            )
        }


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
                    onContentClick = { onContentClick })
            }
        }
    }
}

@Preview
@Composable
private fun  UpcomingSectionPreview(
) {
    LETSSOPTTheme {
        UpcomingSection(contents = HomeFakeData.upcomingContentData, onContentClick = {}, onMoreClick = {})
    }

}
