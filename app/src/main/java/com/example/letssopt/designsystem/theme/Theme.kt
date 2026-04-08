package com.example.letssopt.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

private val LETSSOPTColorScheme = darkColorScheme(
    primary = LETSSOPTColors.PrimaryRed,
    background = LETSSOPTColors.Background,
    surface = LETSSOPTColors.Surface,
    onPrimary = LETSSOPTColors.TextPrimary,
    onBackground = LETSSOPTColors.TextPrimary,
    onSurface = LETSSOPTColors.TextPrimary,
)


@Composable
fun LETSSOPTTheme(
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalLETSSOPTTypography provides typography
    ) {
        MaterialTheme(
            colorScheme = LETSSOPTColorScheme,
            content = content
        )
    }
}
