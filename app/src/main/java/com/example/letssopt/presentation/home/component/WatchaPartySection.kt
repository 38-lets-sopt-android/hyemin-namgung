package com.example.letssopt.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.WatchaPartyModel
import kotlinx.collections.immutable.ImmutableList


@Composable
fun WatchaPartySection(
    parties: ImmutableList<WatchaPartyModel>,
    onPartyClick: (WatchaPartyModel) -> Unit,
    onAlarmClick: (WatchaPartyModel) -> Unit,
    onMoreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "왓챠 파티",
                modifier = Modifier.weight(1f),
                color = LETSSOPTColors.TextPrimary,
                style = typography.h3
            )

            Text(
                text = "더보기",
                modifier = Modifier.noRippleClickable(onClick = onMoreClick),
                color = LETSSOPTColors.TextSecondary,
                style = typography.caption1
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(start = 8.dp)
        ) {
            items(
                items = parties,
                key = { it.id }
            ) { party ->
                WatchaPartyCard(
                    party = party,
                    onClick = { onPartyClick(party) },
                    onAlarmClick = { onAlarmClick(party) }
                )
            }
        }
    }
}

@Composable
fun WatchaPartyCard(
    party: WatchaPartyModel,
    onClick: () -> Unit,
    onAlarmClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(LETSSOPTColors.Surface)
            .noRippleClickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .aspectRatio(4f / 3f)
        ) {
            Image(
                painter = painterResource(id = party.imageRes),
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )


            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .noRippleClickable(onClick = onAlarmClick),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_alramcircle),
                    contentDescription = null,
                    tint = LETSSOPTColors.Background,
                    modifier = Modifier.size(35.dp)
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(LETSSOPTColors.Surface)
                .padding(horizontal = 12.dp, vertical = 12.dp)
        ) {
            Text(
                text = "오늘 ${party.startTime}에 시작",
                color = LETSSOPTColors.PrimaryRed,
                style = typography.body1
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "# ${party.title}",
                color = LETSSOPTColors.TextPrimary,
                style = typography.subH1
            )
        }
    }
}

@Preview
@Composable
private fun WatchaPartySectionPreview() {
    LETSSOPTTheme {
        WatchaPartySection(
            parties = HomeFakeData.watchaPartyData,
            onPartyClick = {},
            onAlarmClick = {},
            onMoreClick = {}
        )
    }
}
