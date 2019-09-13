package ${packageName}

import androidx.navigation.NavController
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

class ${functionalityName}Navigator(override val navController: NavController) : EmaNavigator<${functionalityName}Navigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

        object Destination : ${functionalityName}Navigator.Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
            }
        }
    }

    fun toDestination() {
        navigateWithAction(R.id.navigationAction)
    }
}