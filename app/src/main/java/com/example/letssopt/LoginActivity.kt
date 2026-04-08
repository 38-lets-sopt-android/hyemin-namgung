package com.example.letssopt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.letssopt.ui.theme.LETSSOPTTheme

class LoginActivity  : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LETSSOPTTheme {

            }
        }

    }
}

@Composable
private fun LoginScreen(){

}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}
