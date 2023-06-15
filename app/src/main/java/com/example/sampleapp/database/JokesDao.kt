package com.example.sampleapp.database

import androidx.room.*
import com.example.sampleapp.models.JokesResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface JokesDao {
    @Query("SELECT * FROM Jokes ORDER BY timeStamp DESC")
    fun getJokes(): Flow<MutableList<JokesResponse>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(joke: JokesResponse)

    @Query("DELETE FROM Jokes WHERE joke IN (SELECT joke FROM Jokes ORDER BY timeStamp DESC LIMIT 1 OFFSET 10)")
    suspend fun deleteUnnecessary()
}