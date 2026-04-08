package com.example.letssopt.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.typography

@Composable
fun SubmitButton(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = LETSSOPTColors.PrimaryRed,
            disabledContainerColor = LETSSOPTColors.Disabled,
            contentColor = LETSSOPTColors.TextPrimary,
            disabledContentColor = LETSSOPTColors.Placeholder,
        )
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            style = typography.h3,
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
