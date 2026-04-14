package com.example.letssopt.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    titleText: String,
    placeholder: String,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = titleText,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 3.dp),
            style = typography.caption,
            color = LETSSOPTColors.TextSecondary
        )

        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = LETSSOPTColors.Surface,
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = LETSSOPTColors.Surface,
                unfocusedContainerColor = LETSSOPTColors.Surface,
                disabledContainerColor = LETSSOPTColors.Surface,
                focusedTextColor = LETSSOPTColors.TextPrimary,
                unfocusedTextColor = LETSSOPTColors.Placeholder,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                focusedPlaceholderColor = LETSSOPTColors.Surface,
                unfocusedPlaceholderColor = LETSSOPTColors.Surface,
            ),
            placeholder = {
                Text(
                    text = placeholder,
                    style = typography.caption,
                    color = LETSSOPTColors.Placeholder
                )
            },
            keyboardOptions = keyboardOptions,
            shape = RoundedCornerShape(8.dp),
            maxLines = 1,
            visualTransformation = visualTransformation
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF141414)
@Composable
private fun TextFieldPreview() {
    LETSSOPTTheme {
        AuthTextField(
            value = "",
            onValueChange = {},
            titleText = "비밀번호 확인 ",
            placeholder = "비밀번호를 다시 입력해주세요",
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )
    }
}
