package inc.tesla.dikidi.application

import android.support.annotation.LayoutRes

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
annotation class Layout(@LayoutRes val value: Int)
