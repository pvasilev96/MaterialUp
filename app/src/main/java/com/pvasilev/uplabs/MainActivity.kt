package com.pvasilev.uplabs

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ValueCallback<String> {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_google.setOnClickListener { webview.loadUrl("${BuildConfig.BASE_URL}auth/google") }
        btn_twitter.setOnClickListener { webview.loadUrl("${BuildConfig.BASE_URL}auth/twitter") }
        btn_facebook.setOnClickListener { webview.loadUrl("${BuildConfig.BASE_URL}auth/facebook") }
        webview.apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                    super.onPageStarted(view, url, favicon)
                }

                override fun onPageFinished(view: WebView, url: String) {
                    super.onPageFinished(view, url)
                    if (url == BuildConfig.BASE_URL) {
                        view.evaluateJavascript(LOGIN_SCRIPT, this@MainActivity)
                    }
                }

                override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                    return request.url.toString() == BuildConfig.BASE_URL
                }

                override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                    super.onReceivedError(view, request, error)
                }
            }
        }
    }

    override fun onReceiveValue(value: String?) {
    }

    companion object {
        const val LOGIN_SCRIPT = """
                (function() {
                    return window.UPLABS;
                })();
            """
    }
}
