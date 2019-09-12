package es.babel.ema.presentation.ui.home

import androidx.navigation.NavController
import com.carmabs.ema.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.domain.model.User
import es.babel.ema.presentation.ui.user.EmaUserState

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */
class EmaHomeNavigator(override val navController: NavController) : EmaNavigator<EmaHomeNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

        class User(private val user: es.babel.domain.model.User) : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                (navigator as? EmaHomeNavigator)?.toUser(user)
            }
        }

        object Error: Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                (navigator as? EmaHomeNavigator)?.toError()
            }
        }
    }

    private fun toUser(user: User) {
        navigateWithAction(
                R.id.action_homeViewFragment_to_userFragment,
                addInputState(EmaUserState(user.name, user.surname))
        )
    }

    private fun toError() {
        navigateWithAction(
                R.id.action_homeViewFragment_to_emaErrorViewActivity)
    }
}