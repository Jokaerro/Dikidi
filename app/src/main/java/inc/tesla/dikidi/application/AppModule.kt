package inc.tesla.dikidi.application

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import inc.tesla.dikidi.modules.info.InfoActivity
import inc.tesla.dikidi.modules.main.MainActivity

@Module(includes = arrayOf(AndroidSupportInjectionModule::class))
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class))
    fun mainActivityInjector(): MainActivity

//    @ActivityScope
//    @ContributesAndroidInjector(modules = arrayOf(ActivityModule::class))
//    fun infoActivityInjector(): InfoActivity
}
