package com.aspen_compose.ui.welcome_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.aspen_compose.R

@Composable
fun WelcomeBackground() {
    Image(
        painter = painterResource(id = R.drawable.background_picture),
        contentDescription = "background",
        contentScale = ContentScale.Crop
    )
}