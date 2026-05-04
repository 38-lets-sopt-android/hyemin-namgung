package com.example.letssopt.presentation.purchase.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
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

@Composable
fun PurchaseHistoryPosterCard(
    title: String,
    @DrawableRes imageRes: Int,
    isSaved: Boolean,
    onPosterClick: () -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val item = ContentItemModel(
        id = 0L,
        title = title,
        imageRes = imageRes
    )

    Column(
        modifier = modifier
    ) {
        ContentPosterCard(
            item = item,
            onContentClick = onPosterClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            PurchaseSaveButton(
                isSaved = isSaved,
                onClick = onSaveClick,
                modifier = Modifier
                    .align(Alignment.TopEnd)
            )
        }

        Text(
            text = item.title,
            modifier = Modifier.padding(top = 10.dp),
            color = LETSSOPTColors.TextPrimary,
            style = typography.body,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Composable
private fun PurchaseSaveButton(
    isSaved: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backgroundColor = if (isSaved) { LETSSOPTColors.PrimaryRed } else { Color.Black }

    Box(
        modifier = modifier
            .padding(5.dp)
            .size(28.dp)
            .background(
                color = backgroundColor,
                shape = CircleShape
            )
            .noRippleClickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_purchase_ticket),
            contentDescription = null,
            modifier = Modifier.size(14.dp)
        )
    }
}

@Preview
@Composable
private fun PurchasePosterCardPreview() {
    LETSSOPTTheme {
        val item = HomeFakeData.upcomingContentData.first()

        PurchaseHistoryPosterCard(
            title = item.title,
            imageRes = item.imageRes,
            isSaved = true,
            onPosterClick = {},
            onSaveClick = {},
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
private fun PurchaseSaveButtonPreview() {
    LETSSOPTTheme {
        PurchaseSaveButton(
            isSaved = false,
            onClick = {}
        )
    }
}
