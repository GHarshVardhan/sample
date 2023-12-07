package com.example.sampleapp.repos

import com.example.sampleapp.models.Response
import com.example.sampleapp.models.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow


class Repository() {
    private val resultFlow = MutableSharedFlow<MutableList<Result>>()
    val alResults: Flow<MutableList<Result>> = resultFlow

    suspend fun insert(response: Response) {
        response.marketSummaryAndSparkResponse?.result?.let { resultFlow.tryEmit(it) }
    }

}