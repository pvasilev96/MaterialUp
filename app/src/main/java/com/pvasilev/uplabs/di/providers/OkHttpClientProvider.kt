package com.pvasilev.uplabs.di.providers

import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Provider

class OkHttpClientProvider @Inject constructor() : Provider<OkHttpClient> {
    override fun get(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }
}