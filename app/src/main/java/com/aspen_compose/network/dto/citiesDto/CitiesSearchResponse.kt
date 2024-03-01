package com.aspen_compose.network.dto.citiesDto

import com.aspen_compose.network.dto.Response

data class CitiesSearchResponse(
    val data: CitiesData
) : Response()