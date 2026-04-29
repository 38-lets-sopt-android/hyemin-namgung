package com.example.letssopt.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.common.modifier.noRippleClickable
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.typography

@Composable
fun SubmitButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = if (enabled) LETSSOPTColors.PrimaryRed else LETSSOPTColors.Disabled,
                shape = RoundedCornerShape(8.dp)
            )
            .noRippleClickable(
                enabled = enabled,
                onClick = onClick
            )
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            style = typography.h3,
            color = if (enabled) LETSSOPTColors.TextPrimary else LETSSOPTColors.Placeholder,
            textAlign = TextAlign.Center
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun SubmitButtonPreview() {
    SubmitButton(
        text = "회원가입",
        enabled = true,
        onClick = {},
    )
}
