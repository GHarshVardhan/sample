package com.example.sampleapp.network

import android.app.Application
import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.sampleapp.MainApp
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class GetJokesWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
    private val mainRepository: MainRepository,
    private val app: Application
) : CoroutineWorker(context, workerParams) {

    private suspend fun downloadAndSaveJokePeriodically() {
        mainRepository.getJokes().body()?.let { (app as MainApp).repository.insert(it) }
    }

    override suspend fun doWork(): Result {
        return try {
            downloadAndSaveJokePeriodically()
            Result.success()
        } catch (e: Throwable) {
            Result.failure()
        }
    }
}