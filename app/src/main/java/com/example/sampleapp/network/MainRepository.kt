package com.example.sampleapp.network

import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getJokes() = apiHelper.getJokes()
}
