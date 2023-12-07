package com.example.sampleapp.businesslogic

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.sampleapp.MainApp
import com.example.sampleapp.models.Result
import com.example.sampleapp.network.GetResultsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    app: Application,
    getResultsUseCase: GetResultsUseCase
) : ViewModel() {

    val allResults: LiveData<MutableList<Result>> =
        getResultsUseCase.getDownloadedResultsPeriodically().asLiveData()


    init {
        viewModelScope.launch {
            try {
                getResultsUseCase.execute()
            }catch (e: Exception){
                e.printStackTrace()
            }
        }
    }


}