package com.example.sampleapp.network

import com.example.sampleapp.models.JokesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("api?format=json")
    suspend fun getJokes(): Response<JokesResponse>
}
