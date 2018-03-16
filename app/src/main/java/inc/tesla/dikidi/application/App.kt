package inc.tesla.dikidi.application

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v7.app.AppCompatDelegate
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App: Application(), HasActivityInjector {
    companion object {
        private var context: App? = null

        fun getContext(): Context? {
            return if (context != null)
                context as Context
            else
                null
        }
    }
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        context = this

        DaggerAppComponent
                .builder()
                .context(this)
                .commonModule(CommonModule(this))
                .apiModule(ApiModule(this))
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity>? = dispatchingAndroidInjector
}