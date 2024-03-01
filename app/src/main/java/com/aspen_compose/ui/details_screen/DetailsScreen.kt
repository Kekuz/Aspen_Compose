package com.aspen_compose.ui.details_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.ConstraintLayoutScope
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aspen_compose.R
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Hostel
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.backgroundBlue
import com.aspen_compose.ui.theme.backgroundFacilities
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.darkGray
import com.aspen_compose.ui.theme.detailsDescription
import com.aspen_compose.ui.theme.detailsYellow
import com.aspen_compose.ui.theme.green
import com.aspen_compose.ui.theme.lightGray
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.textGray
import com.aspen_compose.ui.theme.travel
import com.aspen_compose.ui.theme.white

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    navigateBack: () -> Unit,
) {
    val hostel by viewModel.hotelState.collectAsState()

    DetailsBody(hostel = hostel, navigateBack = navigateBack)

}

@Composable
fun DetailsBody(hostel: Hostel, navigateBack: () -> Unit = {}) {
    ConstraintLayout {

        val startGuideline = createGuidelineFromStart(20.dp)
        val endGuideline = createGuidelineFromEnd(20.dp)

        val (_image,
            _backButton,
            _like,
            _name,
            _showMap,
            _reviews,
            _readMore,
            _discription,
            _facilitiesLabel,
            _facilities,
            _priceLabel,
            _price,
            _bookButton) = createRefs()

        Image(
            painter = painterResource(id = hostel.image),
            contentDescription = "Place image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(20.dp))
                .constrainAs(_image) {
                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    top.linkTo(parent.top, margin = 20.dp)
                    bottom.linkTo(_name.top, margin = 32.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = "Back button",
            modifier = Modifier
                .clickable {
                    navigateBack()
                }
                .clip(shape = RoundedCornerShape(8.dp))
                .background(backgroundBlue)
                .padding(horizontal = 17.dp, vertical = 15.dp)
                .constrainAs(_backButton) {
                    start.linkTo(parent.start, margin = 32.dp)
                    top.linkTo(parent.top, margin = 32.dp)
                }
        )

        Image(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "Icon heart",
            modifier = Modifier
                .size(width = 44.dp, height = 44.dp)
                .constrainAs(_like) {
                    end.linkTo(parent.end, 34.dp)
                    bottom.linkTo(_image.bottom)
                    top.linkTo(_image.bottom)
                }
                .shadow(elevation = 5.dp, shape = CircleShape)
        )

        //TODO сделать элипсайз
        Text(
            text = hostel.name,
            fontFamily = montserratFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = darkGray,
            modifier = Modifier.constrainAs(_name) {
                start.linkTo(startGuideline)
                bottom.linkTo(_reviews.top, margin = 6.dp)
            }
        )

        Text(
            text = "Show map",
            fontFamily = circularFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = travel,
            modifier = Modifier.constrainAs(_showMap) {
                top.linkTo(_name.top)
                bottom.linkTo(_name.bottom)
                end.linkTo(endGuideline)
            }
        )

        Row(
            Modifier
                .constrainAs(_reviews) {
                    start.linkTo(startGuideline, margin = 3.dp)
                    bottom.linkTo(_discription.top, margin = 16.dp)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = "star icon",
                tint = detailsYellow
            )

            Text(
                text = "${hostel.rate} (${hostel.reviews} Reviews)",
                fontFamily = circularFamily,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = textGray,
            )

        }

        Text(
            text = hostel.description,
            fontFamily = circularFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = detailsDescription,
            modifier = Modifier
                .constrainAs(_discription) {
                    width = Dimension.fillToConstraints
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                    bottom.linkTo(_readMore.top, margin = 9.dp)
                },
        )

        Row(
            modifier = Modifier
                .constrainAs(_readMore) {
                    start.linkTo(startGuideline)
                    bottom.linkTo(_facilitiesLabel.top, margin = 32.dp)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Read more",
                fontFamily = circularFamily,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = travel,
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = "Arrow down",
                tint = travel,
            )
        }

        Text(
            text = "Facilities",
            fontFamily = montserratFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            color = darkGray,
            modifier = Modifier.constrainAs(_facilitiesLabel) {
                start.linkTo(startGuideline)
                bottom.linkTo(_facilities.top, margin = 16.dp)
            }
        )

        LazyRow(
            Modifier
                .constrainAs(_facilities) {
                    bottom.linkTo(_bookButton.top, margin = 29.dp)
                },
            contentPadding = PaddingValues(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            hostel.facilities.forEach { facility ->
                item {
                    FacilitiesItem(
                        icon = choseIcon(facility = facility),
                        text = facility
                    )
                }
            }
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = travel
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(56.dp)
                .constrainAs(_bookButton) {
                    width = Dimension.fillToConstraints
                    bottom.linkTo(parent.bottom, margin = 24.dp)
                    end.linkTo(endGuideline)
                    start.linkTo(_price.end, margin = 56.dp)
                }
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Book Now",
                    fontFamily = circularFamily,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = white,
                    modifier = Modifier.padding(end = 10.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_right),
                    contentDescription = "Arrow right"
                )
            }

        }

        Text(
            text = "Price",
            color = darkGray,
            fontSize = 12.sp,
            fontFamily = circularFamily,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.constrainAs(_priceLabel) {
                start.linkTo(startGuideline)
                bottom.linkTo(_price.top, margin = 4.dp)
            }
        )

        Text(
            text = hostel.price,
            color = green,
            fontSize = 24.sp,
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.constrainAs(_price) {
                start.linkTo(startGuideline)
                bottom.linkTo(parent.bottom, margin = 28.dp)
            }
        )
    }
}

@Composable
fun FacilitiesItem(icon: Painter, text: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundFacilities)
    ) {
        Icon(
            painter = icon,
            tint = lightGray,
            contentDescription = "Facilities icon",
            modifier = Modifier.padding(top = 12.dp, start = 23.dp, end = 23.dp, bottom = 6.dp)
        )
        Text(
            text = text,
            fontFamily = circularFamily,
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            color = lightGray,
            modifier = Modifier.padding(bottom = 12.dp)
        )
    }
}

//TODO Передавать иконку внутри класса
@Composable
private fun choseIcon(facility: String): Painter =
    painterResource(
        id = when (facility) {
            "1 Heater" -> R.drawable.ic_food
            "Dinner" -> R.drawable.ic_food
            "1 Tub" -> R.drawable.ic_bath_tub
            "Pool" -> R.drawable.ic_frame
            else -> R.drawable.ic_wifi
        }
    )


@Preview(device = "spec:width=411dp,height=891dp")
@Composable
fun PreviewDetailsScreen() {
    Aspen_ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            DetailsBody(hostel = Mockup.getHostelById(0))
        }

    }
}