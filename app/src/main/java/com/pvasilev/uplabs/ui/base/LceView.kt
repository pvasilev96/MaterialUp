package com.pvasilev.uplabs.ui.base

interface LceView<in T> : BaseView {
    fun showData(data: T)
}