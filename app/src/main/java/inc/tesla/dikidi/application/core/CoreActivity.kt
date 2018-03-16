package inc.tesla.dikidi.application.core

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import butterknife.ButterKnife
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import inc.tesla.dikidi.R
import inc.tesla.dikidi.application.LayoutBinder
import inc.tesla.dikidi.application.fragments.FragmentFieldBinder
import org.jetbrains.anko.alert
import org.jetbrains.anko.cancelButton
import org.jetbrains.anko.okButton
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

abstract class CoreActivity<in V : BaseView, P : CorePresenter<V>, N : Navigator> : AppCompatActivity(),
        HasSupportFragmentInjector, BaseView  {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    lateinit var presenter: P
    @Inject
    lateinit var navigator: N


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        LayoutBinder.bind(this)
        ButterKnife.bind(this)
        FragmentFieldBinder.bind(this)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    override fun onStart() {
        super.onStart()
        presenter.takeView(this as V)
    }

    override fun onStop() {
        presenter.detachView()
        super.onStop()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(this, throwable.localizedMessage, Toast.LENGTH_SHORT).show()
    }

    fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }

    fun showSnackBar(message: String, success: Boolean = false) {
        val snackbar = Snackbar.make(findViewById<View>(android.R.id.content), message, Snackbar.LENGTH_LONG)
        snackbar.show()
    }

    fun getVisibleFragment(): Fragment? {
        val fragments: List<Fragment> = supportFragmentManager.fragments

        for (fragment in fragments) {
            if (fragment.isVisible)
                return fragment
        }

        return null
    }

    fun showAlert(message: String, willExit: Boolean) {
        alert(message, getString(R.string.app_name)) {
            okButton {
                if (willExit) {
                    finish()
                }
            }
        }.show()
    }

    protected fun requestPermission(permission: String, message: String, requestCode: Int) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            alert(message, getString(R.string.app_name)) {
                okButton {
                    ActivityCompat.requestPermissions(this@CoreActivity,
                            arrayOf(permission), requestCode)
                }
                cancelButton {

                }
            }.show()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(permission), requestCode)
        }
    }

    fun updateStatusBarColor(color: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.parseColor(color)
        }
    }
}