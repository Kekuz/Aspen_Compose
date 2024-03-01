package com.aspen_compose.network

import com.aspen_compose.network.dto.Response

interface NetworkClient {
    suspend fun doRequest(dto: Any): Response
}