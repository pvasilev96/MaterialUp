package com.pvasilev.uplabs.di.providers

import com.squareup.moshi.Moshi
import javax.inject.Inject
import javax.inject.Provider

class MoshiProvider @Inject constructor() : Provider<Moshi> {
    override fun get(): Moshi {
        return Moshi.Builder().build()
    }
}