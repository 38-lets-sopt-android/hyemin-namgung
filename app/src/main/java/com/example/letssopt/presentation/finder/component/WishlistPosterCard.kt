package com.example.letssopt.presentation.finder.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.R
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.component.ContentPosterCard
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.presentation.home.HomeFakeData
import com.example.letssopt.presentation.home.model.ContentItemModel


@Composable
fun WishlistPosterCard(
    item: ContentItemModel,
    onContentClick: () -> Unit,
    onDeleteClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        ContentPosterCard(
            item = item,
            onContentClick = onContentClick
        )

        Icon(
            painter = painterResource(id = R.drawable.ic_deletecircle),
            contentDescription = null,
            modifier = Modifier.noRippleClickable(onClick = onDeleteClick),
            tint = Color.Unspecified
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WishlistPosterCardPreview(){
    LETSSOPTTheme {
        WishlistPosterCard(
            item = HomeFakeData.upcomingContentData.first(),
            onContentClick =  {},
            onDeleteClick = {}
        )
    }
}
