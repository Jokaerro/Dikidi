package inc.tesla.dikidi.modules.main

import inc.tesla.dikidi.application.core.BaseView
import inc.tesla.dikidi.repository.models.Info

interface MainView: BaseView {
    fun showInfo(info: Info)
}