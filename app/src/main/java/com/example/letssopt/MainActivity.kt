package com.example.letssopt

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.letssopt.ui.theme.LETSSOPTColors
import com.example.letssopt.ui.theme.LETSSOPTTheme
import com.example.letssopt.ui.theme.typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val email = intent.getStringExtra("email")

        enableEdgeToEdge()

        setContent {
            LETSSOPTTheme {
                Scaffold { innerPadding ->
                    MainScreen(
                        email = email ?: "",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    email: String, modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(LETSSOPTColors.Background)
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(6f))

        Text(
            text = "로그인이 완료되었습니다",
            modifier = Modifier.fillMaxWidth(),
            style = typography.h2,
            color = LETSSOPTColors.TextPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "이메일",
            modifier = Modifier.fillMaxWidth(),
            style = typography.caption,
            color = LETSSOPTColors.TextSecondary
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            text = email,
            modifier = Modifier.fillMaxWidth(),
            style = typography.body,
            color = LETSSOPTColors.TextPrimary,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                val intent = Intent(context, LoginActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = LETSSOPTColors.PrimaryRed,
                contentColor = LETSSOPTColors.TextPrimary
            )
        ) {
            Text(
                text = "로그아웃",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                textAlign = TextAlign.Center,
                style = typography.h3
            )
        }

        Spacer(modifier = Modifier.weight(6f))
    }
}

@Preview(showBackground = true)
@Composable
private fun MainScreenPreview() {
    LETSSOPTTheme {
        MainScreen(
            email = "sopt.org",
        )
    }
}
