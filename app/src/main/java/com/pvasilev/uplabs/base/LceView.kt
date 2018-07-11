package com.pvasilev.uplabs.base

interface LceView<in T> : BaseView {
    fun showData(data: T)
}