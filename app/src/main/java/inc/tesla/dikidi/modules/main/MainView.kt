package inc.tesla.dikidi.modules.main

import inc.tesla.dikidi.application.core.BaseView

interface MainView: BaseView {
    fun showToast(message: String)
}