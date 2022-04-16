import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
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

class MainRepository {

    fun completableFromAction(callback: MainCallback.StateResponse, action: () -> Unit) {
        Completable.fromAction { action() }
            .execute(object : MainCallback.StateResponse {
                override fun onSuccess() {
                    println("completableFromAction : onSuccess")
                    callback.onSuccess()
                }

                override fun onFailed(message: String) {
                    println("completableFromAction : onFailed")
                    callback.onFailed(message)
                }

                override fun onFinish() {
                    println("completableFromAction : onFinish")
                    callback.onFinish()
                }

                override fun showProgress() {
                    println("completableFromAction : showProgress")
                    callback.showProgress()
                }

                override fun hideProgress() {
                    println("completableFromAction : hideProgress")
                    callback.hideProgress()
                }

            })
    }

    fun observableFromAction(callback: MainCallback.StateResponse, action: () -> Unit) {
        Observable.fromAction<String> { action() }
            .execute(object : MainCallback.DataResponse<String> {
                override fun onSuccess(data: String) {
                    println("observableFromAction : onSuccess : $data")
                }

                override fun onFailed(message: String) {
                    println("observableFromAction : onFailed : $message")
                    callback.onFailed(message)
                }

                override fun onSubscribe(d: Disposable) {
                    println("observableFromAction : onSubscribe")
                    callback.onSuccess()
                }

                override fun onFinish() {
                    println("observableFromAction : onFinish")
                    callback.onFinish()
                }

                override fun showProgress() {
                    println("observableFromAction : showProgress")
                    callback.showProgress()
                }

                override fun hideProgress() {
                    println("observableFromAction : hideProgress")
                    callback.hideProgress()
                }
            })
    }

    fun observableJust(callback: MainCallback.DataResponse<String>) {
        Observable.just("Hello World", "Hello Kotlin")
            .execute(object : MainCallback.DataResponse<String> {
                override fun onSuccess(data: String) {
                    println("observableJust : onSuccess : $data")
                    callback.onSuccess(data)
                }

                override fun onFailed(message: String) {
                    println("observableJust : onFailed : $message")
                    callback.onFailed(message)
                }

                override fun onSubscribe(d: Disposable) {
                    println("observableJust : onSubscribe")
                    callback.onSubscribe(d)
                }

                override fun onFinish() {
                    println("observableJust : onFinish")
                    callback.onFinish()
                }

                override fun showProgress() {
                    println("observableJust : showProgress")
                    callback.showProgress()
                }

                override fun hideProgress() {
                    println("observableJust : hideProgress")
                    callback.hideProgress()
                }

            })
    }

    fun observableCreate(emitData: String, callback: MainCallback.DataResponse<String>) {
        Observable.create { emitter: ObservableEmitter<String> ->
            try {
                emitter.onNext(emitData)
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        }.execute(object : MainCallback.DataResponse<String> {
            override fun onSuccess(data: String) {
                println("observableCreate : onSuccess : $data")
                callback.onSuccess(data)
            }

            override fun onFailed(message: String) {
                println("observableCreate : onFailed : $message")
                callback.onFailed(message)
            }

            override fun onSubscribe(d: Disposable) {
                println("observableCreate : onSubscribe")
                callback.onSubscribe(d)
            }

            override fun onFinish() {
                println("observableCreate : onFinish")
                callback.onFinish()
            }

            override fun showProgress() {
                println("observableCreate : showProgress")
                callback.showProgress()
            }

            override fun hideProgress() {
                println("observableCreate : hideProgress")
                callback.showProgress()
            }
        })
    }

}