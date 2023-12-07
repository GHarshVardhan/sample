package com.example.sampleapp.network

import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getResponse(): Response<com.example.sampleapp.models.Response> = apiService.getResponse()
}
