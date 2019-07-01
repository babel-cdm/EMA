package es.babel.ema.presentation.ui.emaway.home

import androidx.navigation.NavController
import com.carmabs.ema.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.ema.domain.model.User
import es.babel.ema.presentation.ui.emaway.user.EmaUserState

/**
 * Project: Ema
 * Created by: cmateob on 20/1/19.
 */
class EmaHomeNavigator(override val navController: NavController) : EmaNavigator<EmaHomeNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

        class User(private val user: es.babel.ema.domain.model.User) : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                (navigator as? EmaHomeNavigator)?.toUser(user)
            }
        }
    }

    private fun toUser(user: User) {
        navigateWithAction(
                R.id.action_homeViewFragment_to_userFragment,
                addInputState(EmaUserState(user.name, user.surname))
        )
    }
}