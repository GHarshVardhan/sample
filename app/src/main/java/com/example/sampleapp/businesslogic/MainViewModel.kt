package com.example.sampleapp.businesslogic

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.sampleapp.MainApp
import com.example.sampleapp.models.JokesResponse
import com.example.sampleapp.network.GetJokesWorker
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application
) : ViewModel() {
    var constraints: Constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

    //Didn't know at the beginning that WorkManager's Minimum Request interval is 15 Minutes
    private val periodicWorkRequest =
        PeriodicWorkRequestBuilder<GetJokesWorker>(1, TimeUnit.MINUTES)
            .setConstraints(constraints).build()
    val allJokes: LiveData<MutableList<JokesResponse>> =
        (app as MainApp).repository.alJokes.asLiveData()


    init {
        WorkManager.getInstance(app.applicationContext).enqueue(periodicWorkRequest)
    }


}