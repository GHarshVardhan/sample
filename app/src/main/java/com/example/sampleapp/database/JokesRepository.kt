package com.example.sampleapp.database

import androidx.annotation.WorkerThread
import com.example.sampleapp.models.JokesResponse
import kotlinx.coroutines.flow.Flow


class JokesRepository(private val jokesRoomDB: JokesRoomDB) {

    val alJokes: Flow<MutableList<JokesResponse>> = jokesRoomDB.jokesDao().getJokes()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(jokesResponse: JokesResponse) {
        jokesRoomDB.jokesDao().insert(jokesResponse)
    }

}