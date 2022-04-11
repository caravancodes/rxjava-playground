import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableEmitter
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


fun main(args: Array<String>) {
    observableFromAction()
    println()
    completableFromAction()
    println()
    observableJust()
    println()
    observableCreate()
}

fun completableFromAction() {
    Completable.fromAction {
        println("Hello from Completable.fromAction")
    }.doOnSubscribe { println("showLoading") }
        .doOnTerminate { println("hideLoading") }
        .subscribe({
            println("Completed")
        }) {
            println("Error")
        }
}

fun observableFromAction() {
    Observable.fromAction<Int> {
        println("GJLS Ramadhan")
    }.doOnSubscribe { println("showLoading") }
        .doOnTerminate { println("hideLoading") }
        .subscribe(object : Observer<Int> {
            override fun onComplete() {
                println("Completed")
            }

            override fun onSubscribe(d: Disposable) {
                println("onSubscribe")
            }

            override fun onNext(t: Int) {
                println("onNext $t")
            }

            override fun onError(e: Throwable) {
                println("onError")
            }
        })
}

fun observableJust() {
    Observable.just("Hello World", "hello Kotlin")
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