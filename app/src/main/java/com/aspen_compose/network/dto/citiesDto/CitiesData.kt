package com.aspen_compose.network.dto.citiesDto

data class CitiesData(
    val iso3 : String,
    val states: List<State>
)