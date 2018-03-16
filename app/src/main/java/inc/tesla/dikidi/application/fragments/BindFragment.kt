package inc.tesla.dikidi.application.fragments

import android.support.annotation.IdRes

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class BindFragment(@IdRes val value: Int)