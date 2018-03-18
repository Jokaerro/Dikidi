package inc.tesla.dikidi.modules.main

import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import inc.tesla.dikidi.R
import inc.tesla.dikidi.application.Layout
import inc.tesla.dikidi.application.core.CoreActivity
import inc.tesla.dikidi.modules.main.adapters.MainAdapter
import inc.tesla.dikidi.repository.models.Info

@Layout(R.layout.activity_main)
class MainActivity : CoreActivity<MainView, MainPresenter, MainRouter>(), MainView, NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawer: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var mainRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)
        mainRecycler = findViewById(R.id.mainRecycler)
        val navView = findViewById<NavigationView>(R.id.nav_view)
        navView.itemIconTintList = null
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        toggle.drawerArrowDrawable.color = Color.parseColor("#ffffffff")
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        presenter.getInfo()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.my_main -> {
                drawer.closeDrawers()
                return true
            }
            R.id.my_shares -> {
                drawer.closeDrawers()
                return true
            }
            R.id.my_notes -> {
                drawer.closeDrawers()
                return true
            }
            R.id.my_messages -> {
                drawer.closeDrawers()
                return true
            }
            R.id.share_link -> {
                drawer.closeDrawers()
                return true
            }
            R.id.business -> {
                drawer.closeDrawers()
                return true
            }
            R.id.contacts -> {
                drawer.closeDrawers()
                return true
            }
        }
        return true
    }

    override fun showInfo(info: Info) {
        toolbar.title = info.title
        val mainAdapter = MainAdapter(info, this)
        val llm = LinearLayoutManager(this)
        llm.orientation = LinearLayoutManager.VERTICAL

        mainRecycler.layoutManager = llm
        mainRecycler.adapter = mainAdapter

    }

}
