package com.aspen_compose.ui.welcome_screen.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.aspen_compose.R
import com.aspen_compose.ui.theme.montserratFamily

@Composable
fun WelcomeBottomText(text: String, fontSize: TextUnit, fontWeight: FontWeight? = null) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 32.dp),
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = colorResource(id = R.color.white),
        fontFamily = montserratFamily,
    )
}
