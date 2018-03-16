package inc.tesla.dikidi.application

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module
class NavigationModule {

    private val mCicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    internal fun provideRouter(): Router = mCicerone.router

    @Provides
    @Singleton
    internal fun provideNavigatorHolder(): NavigatorHolder = mCicerone.navigatorHolder

}
