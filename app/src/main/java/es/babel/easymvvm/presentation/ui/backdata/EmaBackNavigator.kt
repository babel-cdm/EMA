package es.babel.easymvvm.presentation.ui.backdata

import androidx.navigation.NavController
import es.babel.easymvvm.R
import es.babel.easymvvm.android.navigation.EmaNavigator
import es.babel.easymvvm.core.navigator.EmaBaseNavigator
import es.babel.easymvvm.core.navigator.EmaNavigationState

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Date: 2019-11-07
 */

class EmaBackNavigator(
        override val navController: NavController
) : EmaNavigator<EmaBackNavigator.Navigation> {

    sealed class Navigation : EmaNavigationState {

        object Result : Navigation() {
            override fun navigateWith(navigator: EmaBaseNavigator<out EmaNavigationState>) {
                (navigator as? EmaBackNavigator)?.toResult()
            }
        }
    }

    private fun toResult() {
        navigateWithAction(R.id.action_emaBackFragment_to_emaBackResultFragment)
    }
}