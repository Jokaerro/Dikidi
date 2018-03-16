package inc.tesla.dikidi.application

import dagger.Binds
import dagger.Module
import inc.tesla.dikidi.application.core.CorePresenter
import inc.tesla.dikidi.modules.main.MainPresenter


@Module
interface ActivityModule {

    @ActivityScope
    @Binds
    fun mainPresenter(presenter: MainPresenter): CorePresenter<*>
}
