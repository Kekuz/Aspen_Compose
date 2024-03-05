package com.aspen_compose.ui.main_screen.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.backgroundBlue
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.lightGray
import com.aspen_compose.ui.theme.travel

@Composable
fun Categories(modifier: Modifier = Modifier, contentPadding: PaddingValues = PaddingValues()) {
    val buttons = listOf("Location", "Hotels", "Food", "Adventure")
    val selectedButton = remember { mutableStateOf(buttons.first()) }

    LazyRow(
        modifier,
        contentPadding = contentPadding,
    ) {
        buttons.forEach {
            item {
                RadioCategory(text = it, selectedButton = selectedButton)
            }
        }
    }
}

@Composable
fun RadioCategory(text: String, selectedButton: MutableState<String>) {
    val isSelected = text == selectedButton.value
    val color = if (isSelected) backgroundBlue else Color.Transparent
    //TODO Можно использовтаь Chip
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = travel
        ),
        onClick = { selectedButton.value = text },
        shape = RoundedCornerShape(33.dp)
    ) {
        Box(Modifier.fillMaxWidth()) {
            if (isSelected) {
                Chip(text = text, color = travel, fontWeight = FontWeight.Bold)
            } else {
                Chip(text = text, color = lightGray, fontWeight = FontWeight.Normal)
            }
        }
    }
}

@Composable
fun Chip(text: String, color: Color, fontWeight: FontWeight) {
    Text(
        text = text,
        color = color,
        fontFamily = circularFamily,
        fontWeight = fontWeight,
        fontSize = 14.sp
    )
}

@Preview
@Composable
fun PreviewCategories() {
    Aspen_ComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Categories()
        }

    }
}