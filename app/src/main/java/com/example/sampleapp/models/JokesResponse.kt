package com.example.sampleapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Jokes")
data class JokesResponse(
    val joke: String = "",
    @PrimaryKey val timeStamp: Long = System.currentTimeMillis()
)
