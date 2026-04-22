package com.example.letssopt.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel
import kotlinx.collections.immutable.ImmutableList

@Composable
fun NewContentSection(
    contents: ImmutableList<ContentItemModel>,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {

        Text(
            text = "방금 막 도착한 신상 컨텐츠",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 19.dp, bottom = 4.dp),
            color = LETSSOPTColors.TextPrimary,
            style = typography.h3
        )

        Text(
            text = "예능부터 드라마까지!",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 19.dp),
            color = LETSSOPTColors.TextSecondary,
            style = typography.subH1
        )

        Spacer(Modifier.height(24.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(
                items = contents,
                key = { it.id }
            ) { item ->
                NewContentCard(item = item, onContentClick = { onContentClick })
            }
        }

    }
}

@Composable
private fun NewContentCard(
    item: ContentItemModel,
    onContentClick: () -> Unit,
    modifier: Modifier = Modifier

) {
    Box(
        modifier = modifier
            .width(390.dp)
            .aspectRatio(39f / 16f)
            .clip(RoundedCornerShape(10.dp))
            .noRippleClickable(onClick = onContentClick)
    ) {
        Image(
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun NewContentSectionPreview() {
    LETSSOPTTheme {
        NewContentSection(contents = HomeFakeData.newContentsData, onContentClick = { })
    }
}
