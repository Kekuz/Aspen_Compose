package com.aspen_compose.model.cities

import com.aspen_compose.network.model.Response

data class CitiesSearchResponse(
    val data: CitiesData
) : Response()