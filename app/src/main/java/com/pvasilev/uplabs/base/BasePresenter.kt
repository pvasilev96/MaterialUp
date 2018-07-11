package com.pvasilev.uplabs.base

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
open class BasePresenter @Inject constructor(private val router: Router) : MvpPresenter<BaseView>() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        disposables.dispose()
    }

    open fun onBackPressed() {
        router.exit()
    }
}