package com.example.sampleapp

import android.app.Application
import androidx.work.Configuration
import com.example.sampleapp.repos.Repository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

@HiltAndroidApp
class MainApp : Application(), Configuration.Provider {

    // No need to cancel this scope as it'll be torn down with the process
    private val applicationScope = CoroutineScope(SupervisorJob())


    val repository by lazy { Repository() }
    override fun getWorkManagerConfiguration(): Configuration {
        TODO("Not yet implemented")
    }

}