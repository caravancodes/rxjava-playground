import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/*
 * Created by faisalamir on 17/04/22
 * rxjava-playground
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 * Copyright (C) 2022 FrogoBox Inc.      
 * All rights reserved
 *
 */

fun <T : Any> Observable<T>.execute(callback: MainCallback.DataResponse<T>) {
    doOnSubscribe { callback.showProgress() }
        .doOnTerminate { callback.hideProgress() }
        .subscribe(object : Observer<T> {
            override fun onSubscribe(d: Disposable) {
                callback.onSubscribe(d)
            }

            override fun onNext(t: T) {
                callback.onSuccess(t)
            }

            override fun onError(e: Throwable) {
                e.message?.let { callback.onFailed(it) }
                callback.onFinish()
            }

            override fun onComplete() {
                callback.onFinish()
            }
        })
}

fun Completable.execute(callback: MainCallback.StateResponse) {
    callback.showProgress()
    subscribe({
        callback.hideProgress()
        callback.onSuccess()
        callback.onFinish()
    }) {
        callback.hideProgress()
        callback.onFailed(it.message!!)
        callback.onFinish()
    }
}