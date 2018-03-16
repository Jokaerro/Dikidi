package inc.tesla.dikidi.application

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AppModule::class,
        NavigationModule::class,
        ApiModule::class,
        CommonModule::class
        ))

interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun commonModule(commonModule: CommonModule): Builder

        fun apiModule(apiModule: ApiModule): Builder

        fun build(): AppComponent
    }

    fun inject(application: App)
}
