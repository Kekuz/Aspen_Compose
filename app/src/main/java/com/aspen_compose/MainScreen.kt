package com.aspen_compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.backgroundBlue
import com.aspen_compose.ui.theme.black
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.darkGray
import com.aspen_compose.ui.theme.lightGray
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.textGray
import com.aspen_compose.ui.theme.travel

@Composable
fun MainScreen() {
    LazyColumn {
        item { CurrentPlace() }
        item { SearchField() }
        item { Categories() }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Separator(text = "Popular")
                SeeAll()
            }
        }
    }
}

@Composable
fun Separator(text: String) {
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        color = darkGray,
        fontFamily = montserratFamily,
        modifier = Modifier.padding(start = 20.dp, top = 32.dp, end = 20.dp)
    )
}

@Composable
fun SeeAll() {
    Text(
        text = "See all",
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = travel,
        fontFamily = circularFamily,
        modifier = Modifier.padding(start = 20.dp, top = 32.dp, end = 20.dp)
    )
}

@Composable
fun Categories() {
    val buttons = listOf("Location", "Hotels", "Food", "Adventure")
    val selectedButton = remember { mutableStateOf(buttons.first()) }

    LazyRow(Modifier.padding(start = 20.dp, top = 32.dp)) {
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

    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = travel
        ),
        onClick = { selectedButton.value = text },
        shape = RoundedCornerShape(33.dp)
    ) {
        Box(Modifier.fillMaxSize()) {
            if (isSelected) {
                Text(text = text)
            } else {
                Text(text = text, color = lightGray)
            }
        }
    }
}

@Composable
fun CurrentPlace() {
    Row(
        Modifier
            .padding(
                top = 44.dp, start = 20.dp, end = 24.dp
            )
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Column {
            TitleText(text = "Explore", fontSize = 14.sp, fontWeight = FontWeight.Normal)
            TitleText(text = "Aspen", fontSize = 32.sp, fontWeight = FontWeight.Medium)
        }
        Row {
            Image(
                modifier = Modifier.padding(end = 8.dp),
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "Place icon"
            )
            PlaceText(text = "Aspen, USA", fontSize = 12.sp, fontWeight = FontWeight.Normal)
            Image(
                modifier = Modifier.padding(start = 8.dp),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Place icon"
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchField() {
    val textField = remember { mutableStateOf("") }
    TextField(
        //TODO использовать SearchBar
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 20.dp, end = 20.dp),
        value = textField.value,
        onValueChange = { value -> textField.value = value },
        label = { HintText("Find things to do") },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Icon search",
                tint = lightGray
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = backgroundBlue,
            //focusedIndicatorColor = backgroundGray,
            cursorColor = black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(24.dp),
        singleLine = true,
    )
}

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

@Composable
fun PlaceText(text: String, fontSize: TextUnit, fontWeight: FontWeight? = null) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = textGray,
        fontFamily = circularFamily,
    )
}

@Composable
fun HintText(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium,
        color = lightGray,
        fontFamily = circularFamily,
    )
}

@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun PreviewMainScreen() {
    Aspen_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            MainScreen()
        }

    }
}