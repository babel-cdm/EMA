package es.babel.easymvvm.presentation.ui.backdata

import es.babel.easymvvm.android.viewmodel.EmaViewModel
import es.babel.easymvvm.presentation.base.BaseViewModel

/**
 *<p>
 * Copyright (c) 2020, Babel Sistemas de Información. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:apps.carmabs@gmail.com”>Carlos Mateo Benito</a>
 *
 * Date: 2019-11-07
 */

class EmaBackToolbarViewModel : BaseViewModel<EmaBackToolbarState, EmaBackNavigator.Navigation>() {

    override val initialViewState: EmaBackToolbarState = EmaBackToolbarState()


    override fun onStartFirstTime(statePreloaded: Boolean) {

    }
}