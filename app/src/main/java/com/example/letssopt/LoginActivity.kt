package com.example.letssopt

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.common.noRippleClickable
import com.example.letssopt.designsystem.component.AuthTextField
import com.example.letssopt.designsystem.component.SubmitButton
import com.example.letssopt.designsystem.theme.LETSSOPTColors
import com.example.letssopt.designsystem.theme.LETSSOPTTheme
import com.example.letssopt.designsystem.theme.typography

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            LETSSOPTTheme {
                LoginScreen()
            }
        }

    }
}

@Composable
private fun LoginScreen(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    var inputEmail by remember { mutableStateOf("") }
    var inputPw by remember { mutableStateOf("") }

    var registerEmail by remember { mutableStateOf("") }
    var registerPw by remember { mutableStateOf("") }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            registerEmail = result.data?.getStringExtra("registerEmail") ?: ""
            registerPw = result.data?.getStringExtra("registerPw") ?: ""
        }
    }

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = LETSSOPTColors.Background)
                .padding(innerPadding)
                .padding(20.dp)
                .imePadding()
        ) {
            Spacer(Modifier.weight(60f))

            Text(
                text = "watcha",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = typography.logo,
                color = LETSSOPTColors.PrimaryRed
            )

            Spacer(Modifier.weight(26f))

            Text(
                text = "이메일로 로그인",
                modifier = Modifier.fillMaxWidth(),
                style = typography.h2,
                color = LETSSOPTColors.TextPrimary
            )

            Spacer(Modifier.weight(36f))

            AuthTextField(
                value = inputEmail,
                onValueChange = { inputEmail = it },
                titleText = "이메일",
                placeholder = "이메일 주소를 입력해주세요 (ex.sopt@sopt.org)",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next, keyboardType = KeyboardType.Email
                ),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(Modifier.weight(18f))

            AuthTextField(
                value = inputPw,
                onValueChange = { inputPw = it },
                titleText = "비밀번호",
                placeholder = "8~12자의 비밀번호를 입력해주세요!",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done, keyboardType = KeyboardType.Password
                ),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(Modifier.weight(333f))

            Text(
                text = "아직 계정이 없으신가요? 회원가입",
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable(
                        onClick = {
                            val intent = Intent(context, SignUpActivity::class.java)
                            launcher.launch(intent)
                        },
                    ),
                style = typography.caption,
                color = LETSSOPTColors.TextSecondary,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline
            )

            Spacer(Modifier.weight(20f))

            SubmitButton(
                text = "로그인",
                enabled = true,
                onClick = {
                    if (inputEmail == registerEmail && inputPw == registerPw) {
                        val intent = Intent(context, MainActivity::class.java).apply {
                            putExtra("email", registerEmail)
                            putExtra("pw", registerPw)
                        }
                        Toast.makeText(context, "로그인에 성공했습니다", Toast.LENGTH_SHORT).show()
                        context.startActivity(intent)
                    } else {
                        Toast.makeText(context, "이메일 또는 비밀번호가 올바르지 않습니다", Toast.LENGTH_SHORT).show()
                    }
                },
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LETSSOPTTheme {
        LoginScreen()
    }
}
