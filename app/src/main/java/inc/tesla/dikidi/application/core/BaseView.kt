package inc.tesla.dikidi.application.core

interface BaseView {
    fun onError(throwable: Throwable)
    fun lockUI() { throw Exception("lockUI not implemented") }
    fun unlockUI() { throw Exception("unlockUI not implemented") }
}