package inc.tesla.dikidi.application

import android.app.Activity
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View

object LayoutBinder {
    fun bind(activity: Activity) {
        val cls = activity.javaClass
        if (!cls.isAnnotationPresent(Layout::class.java)) return
        val layout = cls.getAnnotation(Layout::class.java) as Layout
        activity.setContentView(layout.value)
    }

    fun bind(inflater: LayoutInflater, fragment: Fragment): View? {
        val cls = fragment.javaClass
        if (!cls.isAnnotationPresent(Layout::class.java)) return null
        val layout = cls.getAnnotation(Layout::class.java) as Layout
        return inflater.inflate(layout.value, null)
    }
}