package com.pvasilev.uplabs.data.net

import com.pvasilev.uplabs.data.models.Config
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val config: Config) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val signedRequest = chain.request().newBuilder()
                .addHeader("x-xsrf-token", config.authenticityToken)
                .build()
        return chain.proceed(signedRequest)
    }
}