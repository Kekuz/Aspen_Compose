package com.aspen_compose.network

import com.aspen_compose.network.model.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}