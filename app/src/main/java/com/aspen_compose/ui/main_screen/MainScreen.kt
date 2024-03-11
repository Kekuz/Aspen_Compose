package com.aspen_compose.ui.main_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.aspen_compose.R
import com.aspen_compose.mockup.Mockup
import com.aspen_compose.model.Hostel
import com.aspen_compose.model.Tour
import com.aspen_compose.ui.main_screen.composables.Categories
import com.aspen_compose.ui.main_screen.composables.Location
import com.aspen_compose.ui.main_screen.composables.PopularCard
import com.aspen_compose.ui.main_screen.composables.RecommendedCard
import com.aspen_compose.ui.main_screen.composables.SearchField
import com.aspen_compose.ui.main_screen.composables.Separator
import com.aspen_compose.ui.main_screen.composables.TitleText
import com.aspen_compose.ui.navigation.Destinations
import com.aspen_compose.ui.theme.Aspen_ComposeTheme
import com.aspen_compose.ui.theme.backgroundBlue
import com.aspen_compose.ui.theme.black
import com.aspen_compose.ui.theme.circularFamily
import com.aspen_compose.ui.theme.lightGray
import com.aspen_compose.ui.theme.montserratFamily


@Composable
fun MainScreen(
    viewModel: MainViewModel = hiltViewModel<MainViewModel>(),
    navController: NavController,
) {
    val cities by viewModel.cities.collectAsState()
    val hostels by viewModel.hotels.collectAsState()
    val recommended by viewModel.recommended.collectAsState()

    val navigateToDetails: (Int) -> Unit = { id ->
        navController.navigate(
            route = Destinations.Details(id).route
        )

    }

    MainBody(
        cities,
        hostels,
        recommended,
        navigateToDetails,
    )
}

@Composable
fun MainBody(
    cities: List<String>,
    hostels: List<Hostel>,
    recommended: List<Tour>,
    navigateToDetails: (Int) -> Unit = {},
) {
    LazyColumn {
        item { CurrentPlace(cities) }
        item { SearchField() }
        item { Categories(Modifier.padding(top = 32.dp), PaddingValues(horizontal = 20.dp)) }
        item {
            Separator(textTitle = "Popular", seeAll = true)
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
        item {
            Separator(
                textTitle = "Recommended",
                seeAll = false,
            )
        }
        item {
            LazyRow(
                Modifier.padding(top = 12.dp),
                contentPadding = PaddingValues(horizontal = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                recommended.forEach {
                    item {
                        RecommendedCard(tour = it)
                    }
                }
            }
        }
    }
}


@Composable
fun CurrentPlace(cities: List<String>) {
    Row(
        Modifier
            .padding(top = 44.dp, start = 20.dp, end = 24.dp)
            .fillMaxWidth(),
        Arrangement.SpaceBetween
    ) {
        Column {
            TitleText(text = "Explore", fontSize = 14.sp, fontWeight = FontWeight.Normal)
            TitleText(text = "Aspen", fontSize = 32.sp, fontWeight = FontWeight.Medium)
        }
        Location(cities)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainBody(
        cities = Mockup.cities(),
        hostels = Mockup.hostels(),
        recommended = Mockup.tours()
    )
}