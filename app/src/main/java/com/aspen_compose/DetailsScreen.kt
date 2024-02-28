package com.aspen_compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aspen_compose.ui.theme.Aspen_ComposeTheme

@Composable
fun DetailsScreen(navController: NavHostController) {
    Box(contentAlignment = Alignment.Center) {
        Text(text = "Details", fontSize = 40.sp)
    }

}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun PreviewDetailsScreen() {
    Aspen_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DetailsScreen(navController = rememberNavController())
        }

    }
}