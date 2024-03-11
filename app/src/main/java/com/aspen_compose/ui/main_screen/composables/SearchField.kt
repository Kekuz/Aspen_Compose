package com.aspen_compose.ui.main_screen.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.R
import com.aspen_compose.ui.theme.backgroundBlue
import com.aspen_compose.ui.theme.black
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.lightGray

@Preview(showBackground = true)
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
        label = {
            HintText(text = "Icon search")
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Icon search",
                tint = lightGray
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = backgroundBlue,
            cursorColor = black,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(24.dp),
        singleLine = true,
    )
}

@Composable
private fun HintText(text: String) {
    Text(
        text = text,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium,
        color = lightGray,
        fontFamily = circularFamily,
    )
}