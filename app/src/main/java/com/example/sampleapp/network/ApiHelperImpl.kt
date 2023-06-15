package com.example.sampleapp.network

import com.example.sampleapp.models.JokesResponse
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(
    private val apiService: ApiService
) : ApiHelper {
    override suspend fun getJokes(): Response<JokesResponse> = apiService.getJokes()
}
