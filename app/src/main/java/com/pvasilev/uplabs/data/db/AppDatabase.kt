package com.pvasilev.uplabs.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.pvasilev.uplabs.data.converters.DateAdapter
import com.pvasilev.uplabs.data.models.*

@Database(entities = [Post::class], version = 1)
@TypeConverters(DateAdapter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}