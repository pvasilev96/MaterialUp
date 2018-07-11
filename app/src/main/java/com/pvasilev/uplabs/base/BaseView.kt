package com.pvasilev.uplabs.base

import com.arellomobile.mvp.MvpView

interface BaseView : MvpView {
    fun showProgress(show: Boolean)
    fun showError(show: Boolean, cause: String?)
}