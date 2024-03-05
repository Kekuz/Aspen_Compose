package com.aspen_compose.ui.main_screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.aspen_compose.R
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Hostel
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.backgroundBlue
import com.aspen_compose.ui.theme.backgroundDarkBlue
import com.aspen_compose.ui.theme.black
import com.aspen_compose.ui.theme.borderGray
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.darkGray
import com.aspen_compose.ui.theme.gradientGray
import com.aspen_compose.ui.theme.gray
import com.aspen_compose.ui.theme.hotDealIconColor
import com.aspen_compose.ui.theme.lightGray
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.textGray
import com.aspen_compose.ui.theme.travel
import com.aspen_compose.ui.theme.white
import com.aspen_compose.ui.theme.yellow


@Composable
fun MainScreen(
    viewModel: MainViewModel,
    navigateToDetails: (Int) -> Unit,
) {
    val cities by viewModel.cities.collectAsState()
    val hostels by viewModel.hotelsState.collectAsState()



    MainBody(
        hostels,
        cities,
        navigateToDetails,
    )
}

@Composable
fun MainBody(
    hostels: List<Hostel>,
    cities: List<String>,
    navigateToDetails: (Int) -> Unit = {},
) {
    LazyColumn {
        item { CurrentPlace(cities) }
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
        item {
            LazyRow(
                Modifier.padding(top = 12.dp),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(28.dp)
            ) {
                hostels.forEach {
                    item {
                        PopularCard(
                            hostel = it,
                            navigateToDetails,
                        )
                    }
                }
            }
        }
        item { Separator(text = "Recommended") }
        item {
            LazyRow(
                Modifier.padding(top = 12.dp),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    RecommendedCard(
                        painterResource(id = R.drawable.recommended_mockup2),
                        "Explore Aspen",
                        "4N/5D",
                        true,
                    )
                }
                item {
                    RecommendedCard(
                        painterResource(id = R.drawable.recommended_mockup1),
                        "Luxurious Aspen",
                        "2N/3D",
                        false,
                    )
                }
                item {
                    RecommendedCard(
                        painterResource(id = R.drawable.recommended_mockup2),
                        "Luxurious Aspen",
                        "2N/3D",
                        true,
                    )
                }
            }
        }
    }
}

@Composable
fun RecommendedCard(image: Painter, name: String, interval: String, isHot: Boolean) {
    val brush = Brush.horizontalGradient(listOf(white, gradientGray))
    ConstraintLayout(
        modifier = Modifier
            .width(174.dp)
            .height(142.dp)
            .border(1.dp, borderGray, RoundedCornerShape(16.dp))
            .shadow(
                elevation = 5.dp, shape = RoundedCornerShape(16.dp)
            )
            .clip(shape = RoundedCornerShape(16.dp))
            .background(brush = brush)
    ) {
        val (_image, _name, _interval, _icon, _iconText) = createRefs()

        Image(painter = image,
            contentDescription = "place image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(166.dp)
                .height(96.dp)
                .constrainAs(_image) {
                    height = Dimension.fillToConstraints
                    top.linkTo(parent.top, margin = 4.dp)
                    start.linkTo(parent.start, margin = 4.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
                .clip(shape = RoundedCornerShape(12.dp)))

        Text(text = interval,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = white,
            fontFamily = montserratFamily,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(9.dp))
                .background(color = gray)
                .border(2.dp, white, RoundedCornerShape(9.dp))
                .padding(horizontal = 6.dp, vertical = 4.dp)
                .constrainAs(_interval) {
                    top.linkTo(_image.top, margin = 81.dp)
                    end.linkTo(_image.end, margin = 10.dp)
                })

        Text(text = name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = darkGray,
            fontFamily = circularFamily,
            modifier = Modifier.constrainAs(_name) {
                top.linkTo(_interval.bottom)
                start.linkTo(parent.start, margin = 4.dp)
            })

        if (isHot) {
            Icon(painter = painterResource(id = R.drawable.ic_trending_up),
                contentDescription = "Hot deal",
                tint = hotDealIconColor,
                modifier = Modifier.constrainAs(_icon) {
                    start.linkTo(parent.start, margin = 6.dp)
                    top.linkTo(_name.bottom)
                })

            Text(text = "Hot Deal",
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = darkGray,
                letterSpacing = 0.1.sp,
                fontFamily = circularFamily,
                modifier = Modifier.constrainAs(_iconText) {
                    top.linkTo(_name.bottom)
                    start.linkTo(_icon.end, margin = 4.dp)
                })
        }

    }
}

@Composable
fun PopularCard(hostel: Hostel, navigateToDetails: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .width(188.dp)
            .height(240.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable { navigateToDetails(hostel.id) },
        contentAlignment = Alignment.BottomStart,
    ) {
        Image(
            painter = painterResource(id = hostel.image),
            contentScale = ContentScale.Crop,
            contentDescription = "Hostel picture"
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Column(
                modifier = Modifier.padding(start = 12.dp, bottom = 12.dp), Arrangement.SpaceBetween
            ) {
                NameCard(name = hostel.name)
                Spacer(modifier = Modifier.padding(bottom = 6.dp))
                RateCard(rate = hostel.rate)
            }
            LikeButton(modifier = Modifier.padding(end = 16.dp, bottom = 16.dp))

        }
    }

}

@Composable
fun NameCard(name: String) {
    val ellipsisName = if (name.length > 13) name.slice(0..13) + "..."
    else name

    Text(
        text = ellipsisName,
        textAlign = TextAlign.Center,
        fontSize = 12.sp,
        maxLines = 1,
        fontWeight = FontWeight.Medium,
        color = white,
        fontFamily = montserratFamily,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(59.dp))
            .background(gray)
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}

@Composable
fun RateCard(rate: String) {
    Row(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(59.dp))
            .background(gray)
            .height(27.dp)
            .width(58.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "rate star",
            tint = yellow
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = rate,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            color = white,
            fontFamily = montserratFamily,
        )
    }
}

@Composable
fun LikeButton(modifier: Modifier) {
    Image(
        alignment = Alignment.BottomEnd,
        painter = painterResource(id = R.drawable.ic_heart),
        contentDescription = "heart button",
        modifier = modifier
    )
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

    LazyRow(
        Modifier.padding(top = 32.dp),
        contentPadding = PaddingValues(horizontal = 20.dp),
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
        Box(Modifier.fillMaxSize()) {
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

@Composable
fun CurrentPlace(cities: List<String>) {
    Row(
        Modifier
            .padding(
                top = 44.dp, start = 20.dp, end = 24.dp
            )
            .fillMaxWidth(), Arrangement.SpaceBetween
    ) {
        Column {
            TitleText(text = "Explore", fontSize = 14.sp, fontWeight = FontWeight.Normal)
            TitleText(text = "Aspen", fontSize = 32.sp, fontWeight = FontWeight.Medium)
        }
        Location(cities)
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
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            MainBody(hostels = Mockup.hostels(), cities = Mockup.cities())
        }

    }
}