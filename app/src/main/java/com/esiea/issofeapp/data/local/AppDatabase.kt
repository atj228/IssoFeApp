package com.esiea.issofeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esiea.issofeapp.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}