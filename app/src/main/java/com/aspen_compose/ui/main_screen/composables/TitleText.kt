package com.aspen_compose.ui.main_screen.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.TextUnit
import com.aspen_compose.ui.theme.black
import com.aspen_compose.ui.theme.montserratFamily

@Composable
fun TitleText(text: String, fontSize: TextUnit, fontWeight: FontWeight? = null) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = black,
        fontFamily = montserratFamily,
    )
}

