package es.babel.easymvvm.presentation.base

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.easymvvm.core.state.EmaState

/**
 *  *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo</a>
 */

abstract class BaseViewModel<S, NS : EmaNavigationState> : EmaViewModel<S, NS>(){

    override fun onResume(firstTime: Boolean) {
        //Override if you need to make some operations when view goes to foreground
    }
}