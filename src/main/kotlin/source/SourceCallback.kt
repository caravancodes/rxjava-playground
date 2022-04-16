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

interface SourceCallback {

    interface DataResponse<T> {

        fun onSuccess(data: T)

        fun onFailed(message: String)

        fun onSubscribe(d: Disposable)

        fun onFinish()

        fun showProgress()

        fun hideProgress()

    }

    interface StateResponse {

        fun onSuccess()

        fun onFailed(message: String)

        fun onFinish()

        fun showProgress()

        fun hideProgress()

    }

}