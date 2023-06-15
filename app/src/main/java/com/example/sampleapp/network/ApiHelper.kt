package com.example.sampleapp.network

import com.example.sampleapp.models.JokesResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getJokes(): Response<JokesResponse>
}
