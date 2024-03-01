package com.aspen_compose.network.repository

import android.content.Context
import android.util.Log
import com.aspen_compose.R
import com.aspen_compose.network.NetworkClient
import com.aspen_compose.network.Resource
import com.aspen_compose.network.dto.CitiesRequest
import com.aspen_compose.network.dto.CitiesRequestBody
import com.aspen_compose.network.dto.citiesDto.CitiesData
import com.aspen_compose.network.dto.citiesDto.CitiesSearchResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CitiesRepositoryImpl(
    private val networkClient: NetworkClient,
    private val context: Context
) {

    fun search(): Flow<Pair<CitiesData?, String?>> = flow {
        val response = networkClient.doRequest(CitiesRequest(CitiesRequestBody("United States")))
        when (response.resultCode) {
            -1 -> {
                emit(Pair(null, context.getString(R.string.internet_problems)))

            }

            200 -> {
                Log.d("Response", (response as CitiesSearchResponse).data.toString())
                with(response as CitiesSearchResponse) {
                    emit(Pair(response.data, null))
                }
            }

            else -> {
                emit(Pair(null, context.getString(R.string.server_error)))
            }
        }
    }
}