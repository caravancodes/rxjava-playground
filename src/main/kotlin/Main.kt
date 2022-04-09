import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


fun main(args: Array<String>) {
    Observable.create { emitter: ObservableEmitter<String> ->
        try {
            val nilai = "a".toInt()
            emitter.onNext("Hello World")
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
        .doOnSubscribe { println("showProgress") }
        .doOnTerminate { println("hideProgress") }
        .subscribe(object : Observer<String> {

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
                d.isDisposed
            }

            override fun onNext(t: String) {
                println(t)
            }

            override fun onError(e: Throwable) {
                println("onError")
            }

            override fun onComplete() {
                println("onComplete")
            }

        })
}