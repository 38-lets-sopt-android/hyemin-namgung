package com.example.letssopt

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.letssopt.ui.theme.LETSSOPTTheme


class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SignUpScreen(
                        modifier = Modifier
                            .padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFF141414))
            .padding(horizontal = 20.dp)

    ) {
        Spacer(Modifier.weight(60f))

        Text(
            text = "watcha",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = Color(0xFFE8003C),
                fontSize = 36.sp,
                fontWeight = FontWeight(
                    700
                )
            )
        )

        Spacer(Modifier.weight(26f))

        Text(
            text = "회원가입",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                color = Color(0xFFFFFFFF),
                fontSize = 20.sp,
                fontWeight = FontWeight(700)
            )
        )

        Spacer(Modifier.weight(36f))

        Text(
            text = "이메일",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 3.dp),
            style = TextStyle(
                color = Color(0xFF999999),
                fontSize = 14.sp,
                fontWeight = FontWeight(400)
            )
        )

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF2A2A2A),
                    shape = RoundedCornerShape(8.dp)
                ),
           colors = TextFieldDefaults.colors(
               focusedContainerColor = Color(0xFF2A2A2A),
               unfocusedContainerColor = Color(0xFF2A2A2A),
               disabledContainerColor = Color(0xFF2A2A2A),
               focusedPlaceholderColor = Color(0xFF2A2A2A),
            unfocusedPlaceholderColor = Color(0xFF2A2A2A),
               ),
            placeholder = {
                Text(
                    text = "이메일 주소를 입력해주세요 (ex.sopt@sopt.org)",
                    style = TextStyle(
                        color = Color(0xFF999999), fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                    )
                )
            },
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(Modifier.weight(18f))
        Text(
            text = "비밀번호",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 3.dp),
            style = TextStyle(
                color = Color(0xFF999999),
                fontSize = 14.sp,
                fontWeight = FontWeight(400)
            )
        )

        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF2A2A2A),
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),
                disabledContainerColor = Color(0xFF2A2A2A),
                focusedPlaceholderColor = Color(0xFF2A2A2A),
                unfocusedPlaceholderColor = Color(0xFF2A2A2A),
            ),
            placeholder = {
                Text(
                    text = "8~12자의 비밀번호를 입력해주세요!",
                    style = TextStyle(
                        color = Color(0xFF999999), fontSize = 14.sp,
                        fontWeight = FontWeight(400)
                    )
                )

            },
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(Modifier.weight(18f))

        Text(
            text = "비밀번호 확인",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 3.dp),

            style = TextStyle(
                color = Color(0xFF999999), fontSize = 14.sp,
                fontWeight = FontWeight(400)
            )
        )


        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFF2A2A2A),
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color(0xFF2A2A2A),
                unfocusedContainerColor = Color(0xFF2A2A2A),
                disabledContainerColor = Color(0xFF2A2A2A),
                focusedPlaceholderColor = Color(0xFF2A2A2A),
                unfocusedPlaceholderColor = Color(0xFF2A2A2A),
            ),
            placeholder = {
                Text(
                    text = "비밀번호를 다시 입력해주세요",
                    style = TextStyle(
                        color = Color(0xFF999999), fontSize = 14.sp,
                        fontWeight = FontWeight(400)

                    )
                )
            },
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(Modifier.weight(280f))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE8003C),
                    shape = RoundedCornerShape(8.dp)
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8003C)
            )
        ) {
            Text(
                text = "회원가입",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                )
            )
        }

        Spacer(Modifier.weight(26f))
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    LETSSOPTTheme {
        SignUpScreen()
    }
}
