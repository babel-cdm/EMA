package es.babel.ema.presentation.ui.error

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.ema.presentation.ui.home.EmaHomeNavigator

/**
 *
 * <p>
 * Copyright (c) 2019, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:carlos.mateo@babel.es”>Carlos Mateo</a>
 */

class EmaToolbarViewModel : EmaViewModel<EmaToolbarState, EmaHomeNavigator.Navigation>() {

    override fun createInitialViewState(): EmaToolbarState = EmaToolbarState()

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }

    fun onActionMenuHideToolbar() {
        hideToolbar()
    }

    fun showToolbar(){
        updateViewState{
            copy(visibility = true)
        }
    }

    fun hideToolbar(){
        updateViewState{
            copy(visibility = false)
        }
    }
}