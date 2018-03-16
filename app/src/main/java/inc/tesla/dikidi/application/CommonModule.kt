package inc.tesla.dikidi.application

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CommonModule(private val context: Context)  {

    @Provides
    fun provideContext(): Context {
        return context
    }

}