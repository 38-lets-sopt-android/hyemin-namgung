package com.example.letssopt.presentation.finder.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography

@Composable
fun EmptyWishlist(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "찜한 목록이 비어 있어요! ",
            style = typography.h3,
            color = LETSSOPTColors.TextPrimary
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = "보고 싶은 컨텐츠를 찜해보세요 !",
            style = typography.caption,
            color = LETSSOPTColors.TextSecondary
        )
    }
}

@Preview
@Composable
fun EmptyWishlistPreview(){
    LETSSOPTTheme {
        EmptyWishlist()
    }
}
