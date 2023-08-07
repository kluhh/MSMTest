package com.example.msmtest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.msmtest.data.database.dao.PeopleDAO
import com.example.msmtest.data.remote.dto.PeopleItemDto

@Database(
    entities = [
        PeopleItemDto::class,
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase:RoomDatabase() {
    abstract fun peopleDao(): PeopleDAO
}


