package inc.tesla.dikidi.application.core

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import butterknife.ButterKnife
import dagger.android.support.AndroidSupportInjection
import inc.tesla.dikidi.application.LayoutBinder
import inc.tesla.dikidi.application.fragments.FragmentFieldBinder
import javax.inject.Inject

abstract class CoreFragment<in V : BaseView, P : CorePresenter<V>> : Fragment(), BaseView {

    @Inject
    lateinit var presenter: P

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        AndroidSupportInjection.inject(this)
        return LayoutBinder.bind(inflater, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ButterKnife.bind(this, view)
        FragmentFieldBinder.bind(this)
        presenter.takeView(this as V)
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun onError(throwable: Throwable) {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }
}