package com.aspen_compose.ui.welcome_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.aspen_compose.R
import com.aspen_compose.ui.navigation.Screen
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.hiatusFamily
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.travel
import com.aspen_compose.ui.welcome_screen.composables.WelcomeBackground
import com.aspen_compose.ui.welcome_screen.composables.WelcomeBottomText


@Composable
fun WelcomeScreen(
    navController: NavController,
) {
    val navigateToMain: () -> Unit = {
        navController.navigate(route = Screen.Main.route) {
            popUpTo(Screen.Welcome.route) {
                inclusive = true
            }
        }
    }

    WelcomeBackground()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(id = R.string.aspen),
            modifier = Modifier.padding(top = 93.dp),
            fontSize = 116.sp,
            color = colorResource(id = R.color.white),
            fontFamily = hiatusFamily,
        )
        Spacer(modifier = Modifier.weight(1f))
        WelcomeBottomText(
            text = stringResource(id = R.string.plan_your),
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
        WelcomeBottomText(
            text = stringResource(id = R.string.luxurious),
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium
        )
        WelcomeBottomText(
            text = stringResource(id = R.string.vacation),
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium
        )
        ExploreButton(navigateToMain)
    }
}

@Composable
fun ExploreButton(navigateToMain: () -> Unit) {
    Button(
        onClick = {
            navigateToMain()
        },
        modifier = Modifier
            .padding(bottom = 48.dp, top = 32.dp)
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        colors = ButtonDefaults.buttonColors(travel),
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(id = R.string.explore),
            Modifier.padding(vertical = 8.dp),
            fontFamily = circularFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    WelcomeScreen(rememberNavController())
}