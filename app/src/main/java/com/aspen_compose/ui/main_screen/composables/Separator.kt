package com.aspen_compose.ui.main_screen.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.darkGray
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.travel

@Composable
fun Separator(textTitle: String, seeAll: Boolean, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 32.dp, start = 20.dp, end = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SeparatorTitle(textTitle)
        if (seeAll) {
            SeeAllText()
        }
    }
}

@Composable
private fun SeparatorTitle(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = darkGray,
        fontFamily = montserratFamily,
    )
}

@Composable
private fun SeeAllText() {
    Text(
        text = "See all",
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = travel,
        fontFamily = circularFamily,
    )
}