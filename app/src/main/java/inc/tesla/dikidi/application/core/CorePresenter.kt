package inc.tesla.dikidi.application.core

interface CorePresenter<in V : BaseView> {

    fun takeView(view: V)

    fun detachView()
}