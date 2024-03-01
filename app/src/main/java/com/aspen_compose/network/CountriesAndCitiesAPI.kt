package com.aspen_compose.network

import com.aspen_compose.network.dto.CitiesRequestBody
import com.aspen_compose.network.dto.citiesDto.CitiesSearchResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface CountriesAndCitiesAPI {
    @POST("api/v0.1/countries/states")
    suspend fun searchCities(
        @Body body: CitiesRequestBody
    ): CitiesSearchResponse
}