package inc.tesla.dikidi.application.core

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

abstract class BasePresenter<V : BaseView> : CorePresenter<V> {
    private val subs = CompositeDisposable()
    var view: V? = null

    override fun takeView(view: V) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
        if (subs.isDisposed) subs.clear()
    }

    fun <T> add(observable: Single<T>, consumer: Consumer<T>) {
        subs.add(observable
                .doOnError {
                    view?.onError(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer, Consumer {
                    it.printStackTrace()
                }))

    }
}