package inc.tesla.dikidi.application.fragments

import android.app.Activity
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

object FragmentFieldBinder {

    fun bind(activity: Activity) {
        val fields = activity.javaClass.declaredFields

        for (field in fields) {
            if (field.isAnnotationPresent(BindFragment::class.java)) {
                val annotation = field.getAnnotation(BindFragment::class.java)
                val fragment = activity.fragmentManager.findFragmentById(annotation.value)
                try {
                    field.set(activity, fragment)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun bind(activity: AppCompatActivity) {
        val fields = activity.javaClass.declaredFields

        for (field in fields) {
            if (field.isAnnotationPresent(BindFragment::class.java)) {
                val annotation = field.getAnnotation(BindFragment::class.java)
                val fragment = activity.supportFragmentManager.findFragmentById(annotation.value)
                try {
                    field.set(activity, fragment)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }

    fun bind(parentFragment: Fragment) {
        val fields = parentFragment.javaClass.declaredFields

        for (field in fields) {
            if (field.isAnnotationPresent(BindFragment::class.java)) {
                val annotation = field.getAnnotation(BindFragment::class.java)
                val fragment = parentFragment.childFragmentManager.findFragmentById(annotation.value)
                try {
                    field.set(parentFragment, fragment)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

            }
        }
    }
}
