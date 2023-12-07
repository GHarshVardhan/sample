package com.example.sampleapp.network

import android.app.Application
import com.example.sampleapp.MainApp
import com.example.sampleapp.models.Response
import com.example.sampleapp.models.Result
import com.example.sampleapp.repos.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetResultsUseCase @Inject constructor(
    private val mainRepository: MainRepository, private val app: Application
) {

    fun getDownloadedResultsPeriodically() = flow { mainRepository.getResponse().body()
        ?.let { it.marketSummaryAndSparkResponse?.let { it1 -> emit(it1.result) } } }

    suspend fun execute() {
        repeat(Int.MAX_VALUE) {
            try {
                getDownloadedResultsPeriodically()
            } catch (e: Exception) {
                e.printStackTrace()
            }
            delay(8000)
        }
    }
}