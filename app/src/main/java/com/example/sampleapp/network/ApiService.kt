package com.example.sampleapp.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("get-summary?region=US/")
    suspend fun getResponse(): Response<com.example.sampleapp.models.Response>
}
