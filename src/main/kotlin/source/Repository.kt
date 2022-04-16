package source

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

class Repository(private val rxDataSource: RxDataSource) : DataSource {

    override fun doMultipleRxJava(callback: SourceCallback.DataResponse<String>) {
        rxDataSource.observableCreate("Process : Do Observable Create", object : SourceCallback.DataResponse<String> {
            override fun onSuccess(data: String) {
                rxDataSource.completableFromAction(object : SourceCallback.StateResponse {
                    override fun onSuccess() {
                        println("Repository doMultipleRxJava : onSuccess")
                        callback.onSuccess(data)
                    }

                    override fun onFailed(message: String) {
                        println("Repository doMultipleRxJava : onFailed")
                        callback.onFailed(message)
                    }

                    override fun onFinish() {
                        println("Repository doMultipleRxJava : onFinish")
                    }

                    override fun showProgress() {
                        println("Repository doMultipleRxJava : showProgress")
                        callback.showProgress()
                    }

                    override fun hideProgress() {
                        println("Repository doMultipleRxJava : hideProgress")
                        callback.hideProgress()
                    }
                }) {
                    println("Process : Do Completable From Action")
                }
            }

            override fun onFailed(message: String) {
                println("Repository doMultipleRxJava : onFailed")
                callback.onFailed(message)
            }

            override fun onSubscribe(d: Disposable) {
                println("Repository doMultipleRxJava : onSubscribe")
                callback.onSubscribe(d)
            }

            override fun onFinish() {
                println("Repository doMultipleRxJava : onFinish")
                callback.onFinish()
            }

            override fun showProgress() {
                println("Repository doMultipleRxJava : showProgress")
                callback.showProgress()
            }

            override fun hideProgress() {
                println("Repository doMultipleRxJava : hideProgress")
                callback.hideProgress()
            }
        })
    }


}