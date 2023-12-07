package com.example.sampleapp.repos

import com.example.sampleapp.network.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
) {
    suspend fun getResponse() = apiHelper.getResponse()

    fun String.getLength(str: String) : Int{
        return str.length;
    }
}
