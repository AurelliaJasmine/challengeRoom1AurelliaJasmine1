package com.example.challengeroom1aurelliajasmine.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [tbsiswa::class],
    version = 1
)
    abstract class dbsmksa : RoomDatabase() {
        abstract fun tbsiswaDAO() : tbsiswaDAO

        companion object {
            @Volatile private var instance : dbsmksa? = null
            private val LOCK = Any()

            operator fun invoke (context: Context) = instance?: synchronized(LOCK){
                instance?:buildDatabase(context).also{
                    instance = it
                }
            }
            private fun buildDatabase(context: Context) = Room.databaseBuilder(
                context.applicationContext,
                dbsmksa::class.java,
                "dbsmksa"
            ).build()
        }
    }