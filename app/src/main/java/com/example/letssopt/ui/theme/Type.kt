package com.example.letssopt.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.letssopt.R

data class LETSSOPTTypography(
    val logo: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val body: TextStyle,
    val caption: TextStyle
)

private val PretendartFontFamily = FontFamily(
    Font(R.font.pretendard_regular, weight = FontWeight.Normal),
    Font(R.font.pretendard_bold, weight = FontWeight.Bold),
)


private val Logo = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 36.sp
)

private val H1 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp
)

private val H2 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 20.sp
)

private val H3 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp
)

private val Body = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)

private val Caption = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
)

val typography = LETSSOPTTypography(
   logo =Logo,
    h1 = H1,
    h2 = H2,
    h3 = H3,
    body = Body,
    caption = Caption
)

val LocalLETSSOPTTypography = staticCompositionLocalOf {
    typography
}
