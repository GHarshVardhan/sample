package com.example.sampleapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.sampleapp.models.JokesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Singleton

@Database(entities = [JokesResponse::class], version = 1, exportSchema = false)
@Singleton
abstract class JokesRoomDB : RoomDatabase() {

    abstract fun jokesDao(): JokesDao

    companion object {

        @Volatile
        private var INSTANCE: JokesRoomDB? = null

        fun getDatabase(context: Context, scope: CoroutineScope): JokesRoomDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JokesRoomDB::class.java,
                    "jokes_database"
                ).addCallback(JokesCallback(scope))
                    .build()

                INSTANCE = instance

                // return instance
                instance
            }
        }
    }

    private class JokesCallback(val scope: CoroutineScope) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { jokesRoomDB ->
                scope.launch {
                    jokesRoomDB.jokesDao().deleteUnnecessary()
                }
            }
        }
    }

}