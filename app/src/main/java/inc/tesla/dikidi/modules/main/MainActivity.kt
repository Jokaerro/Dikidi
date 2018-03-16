package inc.tesla.dikidi.modules.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import inc.tesla.dikidi.R
import inc.tesla.dikidi.application.Layout
import inc.tesla.dikidi.application.core.CoreActivity

@Layout(R.layout.activity_main)
class MainActivity : CoreActivity<MainView, MainPresenter, MainRouter>(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.getInfo()
    }

    override fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}
