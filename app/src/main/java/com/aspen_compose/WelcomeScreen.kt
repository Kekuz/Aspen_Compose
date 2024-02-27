package com.aspen_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.hiatusFamily
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.travel


@Composable
fun WelcomeScreen() {
    Background(Modifier)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Title()
        Spacer(modifier = Modifier.weight(1f))
        BottomText(
            text = stringResource(id = R.string.plan_your),
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal
        )
        BottomText(
            text = stringResource(id = R.string.luxurious),
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium
        )
        BottomText(
            text = stringResource(id = R.string.vacation),
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium
        )
        ExploreButton()
    }
}

@Composable
fun Background(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.background_picture),
        contentDescription = "background",
        modifier = modifier,
        contentScale = ContentScale.Crop
    )
}

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


@Composable
fun BottomText(text: String, fontSize: TextUnit, fontWeight: FontWeight? = null) {
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

@Composable
fun ExploreButton() {
    Button(
        onClick = {
            //TODO Навигацию в следующий экран
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

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun PreviewWelcomeScreen() {
    Aspen_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WelcomeScreen()
        }

    }
}