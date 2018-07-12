package com.pvasilev.uplabs.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.pvasilev.uplabs.data.db.AppDatabase
import com.pvasilev.uplabs.data.db.PostDao
import toothpick.config.Module

class StorageModule(context: Context) : Module() {
    init {
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "uplabs.db").build()
        bind(PostDao::class.java).toInstance(db.postDao())
    }
}