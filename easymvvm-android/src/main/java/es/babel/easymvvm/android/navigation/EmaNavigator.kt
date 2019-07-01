package es.babel.easymvvm.android.navigation


import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaBaseState

/**
 * Navigator to handle navigation through navHost
 * @author <a href="mailto:apps.carmabs@gmail.com">Carlos Mateo Benito</a>
 */
interface EmaNavigator<NS : EmaNavigationState> : EmaBaseNavigator<NS> {

    val navController: NavController

    /**
     * Set the initial state for the incoming fragment. Only work for fragment at the same activity
     * at the moment
     * @param emaBaseState the state for the incoming view
     * @param inputStateKey the key to identify the state. If it not provided, it will take the canonical name
     * of the state
     */
    fun addInputState(emaBaseState: EmaBaseState, inputStateKey: String? = null): Bundle =
            Bundle().apply {
                putSerializable(inputStateKey ?: emaBaseState.javaClass.name, emaBaseState)
            }

    /**
     * Navigate with android architecture components within action ID
     * @param actionID
     * @param data
     * @param navOptions
     */
    fun navigateWithAction(@IdRes actionID: Int, data: Bundle? = null, navOptions: NavOptions? = null) {
        navController.navigate(actionID, data, navOptions)
    }

    /**
     * Navigate with android architecture components within navDirections safeargs
     * @param navDirections
     * @param navOptions
     */
    fun navigateWithDirections(navDirections: NavDirections, navOptions: NavOptions? = null) {
        navController.navigate(navDirections, navOptions)
    }


    /**
     * Navigates back
     * @return true if a fragment has been popped, false if backstack is empty
     */
    fun navigateBack() : Boolean {
        return navController.popBackStack()
    }
}