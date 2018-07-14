package com.pvasilev.uplabs.ui.base

import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter

open class BaseFragment : MvpAppCompatFragment(), BaseView, OnBackPressedListener {
    @InjectPresenter
    lateinit var presenter: BasePresenter

    override fun showProgress(show: Boolean) {
    }

    override fun showError(show: Boolean, cause: String?) {
    }

    override fun onBackPressed() {
        presenter.onBackPressed()
    }
}