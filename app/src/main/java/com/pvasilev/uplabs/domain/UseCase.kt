package com.pvasilev.uplabs.domain

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executor
import javax.inject.Inject

abstract class UseCase<T, in Params> @Inject constructor(
        private val computationExecutor: Executor,
        private val postComputationExecutor: Executor
) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract fun buildUseCase(params: Params): Single<T>

    fun execute(observer: DisposableSingleObserver<T>, params: Params) {
        val useCase = buildUseCase(params)
                .subscribeOn(Schedulers.from(computationExecutor))
                .observeOn(Schedulers.from(postComputationExecutor))
        disposables.add(useCase.subscribeWith(observer))
    }

    fun dispose() = disposables.dispose()
}