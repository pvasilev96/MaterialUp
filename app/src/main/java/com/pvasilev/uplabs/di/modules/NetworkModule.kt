package com.pvasilev.uplabs.di.modules

import com.pvasilev.uplabs.di.providers.MoshiProvider
import com.pvasilev.uplabs.di.providers.OkHttpClientProvider
import com.pvasilev.uplabs.di.providers.RetrofitProvider
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import toothpick.config.Module

class NetworkModule : Module() {
    init {
        bind(Moshi::class.java).toProvider(MoshiProvider::class.java)
        bind(OkHttpClient::class.java).toProvider(OkHttpClientProvider::class.java)
        bind(Retrofit::class.java).toProvider(RetrofitProvider::class.java)
    }
}