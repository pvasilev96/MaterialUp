package com.pvasilev.uplabs.domain

import io.reactivex.observers.DisposableSingleObserver

open class DefaultObserver<T> : DisposableSingleObserver<T>() {
    override fun onSuccess(t: T) {
    }

    override fun onError(e: Throwable) {
    }
}