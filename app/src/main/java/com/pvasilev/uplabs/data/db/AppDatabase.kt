package com.pvasilev.uplabs.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.pvasilev.uplabs.data.models.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}