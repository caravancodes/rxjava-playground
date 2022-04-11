import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


fun main(args: Array<String>) {
    completableFromAction()
}

fun completableFromAction() {
    Completable.fromAction {
        val nilai = "a".toInt()
    }.doOnSubscribe { println("doOnSubscribe") }
        .doOnTerminate { println("doOnTerminate") }
        .subscribe({
            println("Completed")
        }) {
            println("Error")
        }
}

fun observableJust() {
    Observable.just("Hello World")
        .doOnSubscribe { println("showProgress") }
        .doOnTerminate { println("hideProgress") }
        .subscribe(object : Observer<String> {
            override fun onComplete() {
                println("Completed")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                println("onNext $t")
            }

            override fun onError(e: Throwable) {
                println("onError")
            }
        })
}

fun observableCreate() {
    Observable.create { emitter: ObservableEmitter<String> ->
        try {
            emitter.onNext("Hello World")
            emitter.onComplete()
        } catch (e: Exception) {
            emitter.onError(e)
        }
    }
        .doOnSubscribe { println("showProgress") }
        .doOnTerminate { println("hideProgress") }
        .subscribe(object : Observer<String> {
            override fun onComplete() {
                println("onComplete")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: String) {
                println("onNext $t")
            }

            override fun onError(e: Throwable) {
                println("onError ${e.message}")

            }
        })
}