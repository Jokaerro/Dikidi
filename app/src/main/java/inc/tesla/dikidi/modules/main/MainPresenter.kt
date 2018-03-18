package inc.tesla.dikidi.modules.main

import inc.tesla.dikidi.application.core.BasePresenter
import inc.tesla.dikidi.repository.models.Info
import io.reactivex.functions.Consumer
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject
constructor(internal var router: Router, private var interactor: MainInteractor) : BasePresenter<MainView>() {

    fun getInfo() {
        add<Info>(interactor.getCurrentInfo(),
                Consumer<Info> {
                    if (it != null) {
                        view?.showInfo(it)
                    }
                })
    }
}