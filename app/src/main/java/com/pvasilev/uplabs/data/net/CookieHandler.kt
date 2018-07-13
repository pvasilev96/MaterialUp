package com.pvasilev.uplabs.data.net

import android.webkit.CookieManager
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

class CookieHandler : CookieJar {
    private val cookieManager: CookieManager = CookieManager.getInstance()

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        cookies.forEach { cookieManager.setCookie(url.toString(), it.value()) }
    }

    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        return cookieManager.getCookie(url.toString())
                .split(";")
                .map { Cookie.parse(url, it)!! }
    }

}