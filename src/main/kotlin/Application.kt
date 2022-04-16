import io.reactivex.rxjava3.disposables.Disposable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import source.Repository
import source.SourceCallback

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

class Application : KoinComponent {

    private val repository: Repository by inject()

    fun start() {
        repository.doMultipleRxJava(object : SourceCallback.DataResponse<String> {
            override fun onSuccess(data: String) {
                println("#### Run On Ui Thread =====> doMultipleRxJava : onSuccess : $data")
            }

            override fun onFailed(message: String) {
                println("#### Run On Ui Thread =====> doMultipleRxJava : onFailed : $message")
            }

            override fun onSubscribe(d: Disposable) {
                println("#### Run On Ui Thread =====> doMultipleRxJava : onSubscribe : $d")
            }

            override fun onFinish() {
                println("#### Run On Ui Thread =====> doMultipleRxJava : onFinish")
            }

            override fun showProgress() {
                println("#### Run On Ui Thread =====> doMultipleRxJava : showProgress")
            }

            override fun hideProgress() {
                println("#### Run On Ui Thread =====> doMultipleRxJava : hideProgress")
            }
        })
    }

}