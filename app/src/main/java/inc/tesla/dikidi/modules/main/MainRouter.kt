package inc.tesla.dikidi.modules.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import inc.tesla.dikidi.application.Screens
import inc.tesla.dikidi.modules.info.InfoActivity
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Forward
import javax.inject.Inject

class MainRouter @Inject
constructor(interactor: MainActivity) : Navigator {

    private var activity: AppCompatActivity = interactor

    override fun applyCommand(command: Command) {
        forward(command as Forward)
    }

    private fun forward(command: Forward) {
        when (command.screenKey) {
            Screens.ACTIVITY_INFO -> {
                activity.startActivity(Intent(activity, InfoActivity::class.java))
                activity.finish()
            }
            else -> Log.d("MainRouter", "forward screen doesn't exist")
        }

    }
}