package com.aspen_compose.ui.main_screen.composables

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.R
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.backgroundDarkBlue
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.textGray

@Composable
fun Location(cities: List<String>) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    var currentCity by rememberSaveable { mutableStateOf("Aspen") }

    val extraPadding by animateDpAsState(
        if (expanded) 187.dp else 0.dp, label = "",
        animationSpec = spring(
            dampingRatio = if (expanded) {
                Spring.DampingRatioMediumBouncy
            } else {
                Spring.DampingRatioNoBouncy
            },
            stiffness = if (expanded) {
                Spring.StiffnessLow
            } else {
                Spring.StiffnessMedium
            },
        )
    )

    val rotation by animateFloatAsState(
        if (expanded) 180f else 0f, label = "",
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Column(horizontalAlignment = Alignment.End) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .clickable { expanded = !expanded },
        ) {
            Image(
                modifier = Modifier.padding(end = 8.dp),
                painter = painterResource(id = R.drawable.ic_location),
                contentDescription = "Place icon"
            )
            PlaceText(
                text = "${currentCity}, USA",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
            Image(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .rotate(rotation),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Place icon"
            )
        }
        CitiesList(
            extraPadding = extraPadding,
            cities,
            { city -> currentCity = city },
            { expanded = !expanded })
    }
}

@Composable
private fun CitiesList(
    extraPadding: Dp,
    cities: List<String>,
    changeCity: (city: String) -> Unit,
    changeExpanded: () -> Unit
) {
    Box(
        Modifier
            .padding(top = 8.dp)
            .width(180.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundDarkBlue)
            .height(extraPadding)
    ) {
        LazyColumn(
            modifier = Modifier.padding(start = 20.dp),
            contentPadding = PaddingValues(top = 16.dp)
        ) {
            cities.forEach {
                item {
                    Text(
                        text = it,
                        color = textGray,
                        fontFamily = circularFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                changeCity(it)
                                changeExpanded()
                            }
                    )
                }
            }
        }
    }
}

@Composable
private fun PlaceText(text: String, fontSize: TextUnit, fontWeight: FontWeight? = null) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = textGray,
        fontFamily = circularFamily,
    )
}

@Preview
@Composable
fun PreviewLocation() {
    Aspen_ComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            Location(Mockup.cities())
        }

    }
}