package com.pvasilev.uplabs.di.providers

import com.pvasilev.uplabs.data.models.Config
import com.pvasilev.uplabs.data.net.CookieHandler
import com.pvasilev.uplabs.data.net.TokenInterceptor
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Provider

class OkHttpClientProvider @Inject constructor(private val config: Config) : Provider<OkHttpClient> {
    override fun get(): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor(config))
                .cookieJar(CookieHandler())
                .build()
    }
}