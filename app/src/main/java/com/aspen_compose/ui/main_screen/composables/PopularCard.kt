package com.aspen_compose.ui.main_screen.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_compose.R
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Hostel
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.gray
import com.aspen_compose.ui.theme.montserratFamily
import com.aspen_compose.ui.theme.white
import com.aspen_compose.ui.theme.yellow

@Composable
fun PopularCard(hostel: Hostel, navigateToDetails: (Int) -> Unit = {}) {
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
                PopularCardName(name = hostel.name)
                Spacer(modifier = Modifier.padding(bottom = 6.dp))
                PopularCardRate(rate = hostel.rate)
            }
            LikeButton(modifier = Modifier.padding(end = 16.dp, bottom = 16.dp))
        }
    }

}

@Composable
private fun PopularCardName(name: String) {
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
private fun PopularCardRate(rate: String) {
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
private fun LikeButton(modifier: Modifier) {
    Image(
        alignment = Alignment.BottomEnd,
        painter = painterResource(id = R.drawable.ic_heart),
        contentDescription = "heart button",
        modifier = modifier
    )
}

@Preview
@Composable
fun PreviewPopularCard() {
    Aspen_ComposeTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            PopularCard(hostel = Mockup.hostels()[0])
        }

    }
}
