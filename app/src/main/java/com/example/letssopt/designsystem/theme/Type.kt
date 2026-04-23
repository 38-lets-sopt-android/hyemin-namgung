package com.example.letssopt.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.letssopt.R
import org.w3c.dom.Text

data class LETSSOPTTypography(
    val logo: TextStyle,
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val subH1 : TextStyle,
    val subH3 : TextStyle,
    val body: TextStyle,
    val body1 : TextStyle,
    val body2: TextStyle,
    val caption: TextStyle,
    val caption1: TextStyle
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
    fontWeight = FontWeight.W600,
    fontSize = 20.sp
)

private val SubH1 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.W600,
    fontSize = 18.sp
)

private val SubH3 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.W600,
    fontSize = 12.sp
)

private val Body = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)

private val Body1 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.W500,
    fontSize = 12.sp
)

private val Body2 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.W400,
    fontSize = 12.sp
)

private val Caption = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp
)

private val Caption1 = TextStyle(
    fontFamily = PretendartFontFamily,
    fontWeight = FontWeight.W300,
    fontSize = 12.sp
)

val typography = LETSSOPTTypography(
    logo = Logo,
    h1 = H1,
    h2 = H2,
    h3 = H3,
    subH1 = SubH1,
    subH3 = SubH3,
    body = Body,
    body1 = Body1,
    body2 = Body2,
    caption = Caption,
    caption1 = Caption1
)

val LocalLETSSOPTTypography = staticCompositionLocalOf {
    typography
}
