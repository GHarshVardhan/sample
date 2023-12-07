package com.example.sampleapp.network

import retrofit2.Response

interface ApiHelper {
    suspend fun getResponse(): Response<com.example.sampleapp.models.Response>
}
