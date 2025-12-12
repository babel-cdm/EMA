package es.babel.easymvvm.android.navigation

import androidx.navigation.NavController
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 * Navigator without navigations.
 * A navigator always is required by architecture, but sometimes new features has not navigation.
 *
 * @author <a href=“mailto:rafa.lortiz@babelgroup.com”>Rafael Ángel Luque</a>
 */
class EmaNavigatorEmpty(override val navController: NavController) :
    EmaNavigator<EmaNavigatorEmpty.Navigation> {
    sealed class Navigation : EmaNavigationState
}
