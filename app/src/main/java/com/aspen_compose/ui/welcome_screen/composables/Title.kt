package com.aspen_compose.ui.welcome_screen.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.R
import com.aspen_compose.ui.theme.hiatusFamily

@Composable
fun Title() {
    Text(
        text = stringResource(id = R.string.aspen),
        modifier = Modifier.padding(top = 93.dp),
        fontSize = 116.sp,
        color = colorResource(id = R.color.white),
        fontFamily = hiatusFamily,
    )
}