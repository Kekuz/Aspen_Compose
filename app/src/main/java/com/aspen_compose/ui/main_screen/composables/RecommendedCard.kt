package com.aspen_compose.ui.main_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.aspen_compose.R
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Tour
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.borderGray
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.darkGray
import com.aspen_compose.ui.theme.gradientGray
import com.aspen_compose.ui.theme.gray
import com.aspen_compose.ui.theme.hotDealIconColor
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.white

@Composable
fun RecommendedCard(tour: Tour) {
    val brush = Brush.horizontalGradient(listOf(white, gradientGray))

    ConstraintLayout(
        modifier = Modifier
            .width(174.dp)
            .height(166.dp)
            .border(1.dp, borderGray, RoundedCornerShape(16.dp))
            .shadow(
                elevation = 5.dp, shape = RoundedCornerShape(16.dp)
            )
            .clip(shape = RoundedCornerShape(16.dp))
            .background(brush = brush)
    ) {
        val (image, name, interval, icon, iconText) = createRefs()

        Image(painter = painterResource(id = tour.image),
            contentDescription = "place image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(166.dp)
                .height(96.dp)
                .constrainAs(image) {
                    height = Dimension.fillToConstraints
                    top.linkTo(parent.top, margin = 4.dp)
                    start.linkTo(parent.start, margin = 4.dp)
                    end.linkTo(parent.end, margin = 4.dp)
                }
                .clip(shape = RoundedCornerShape(12.dp)))

        Text(text = tour.interval,
            fontSize = 10.sp,
            fontWeight = FontWeight.SemiBold,
            color = white,
            fontFamily = montserratFamily,
            modifier = Modifier
                .clip(shape = RoundedCornerShape(9.dp))
                .background(color = gray)
                .border(2.dp, white, RoundedCornerShape(9.dp))
                .padding(horizontal = 6.dp, vertical = 4.dp)
                .constrainAs(interval) {
                    top.linkTo(image.top, margin = 81.dp)
                    end.linkTo(image.end, margin = 10.dp)
                })

        Text(text = tour.name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            color = darkGray,
            fontFamily = circularFamily,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(interval.bottom)
                start.linkTo(parent.start, margin = 8.dp)
            })


        Icon(painter = painterResource(id = R.drawable.ic_trending_up),
            contentDescription = "Hot deal",
            tint = hotDealIconColor,
            modifier = Modifier.constrainAs(icon) {
                start.linkTo(parent.start, margin = 8.dp)
                top.linkTo(iconText.top)
                bottom.linkTo(iconText.bottom)
            })

        Text(text = "Hot Deal",
            fontSize = 10.sp,
            fontWeight = FontWeight.Normal,
            color = darkGray,
            letterSpacing = 0.1.sp,
            fontFamily = circularFamily,
            modifier = Modifier.constrainAs(iconText) {
                top.linkTo(name.bottom)
                start.linkTo(icon.end, margin = 4.dp)
            }
        )
    }
}

@Preview
@Composable
fun PreviewRecommendedCard() {
    Aspen_ComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            RecommendedCard(Mockup.tours()[1])
        }

    }
}