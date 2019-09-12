package es.babel.ema.presentation.ui.user

import es.babel.easymvvm.core.navigator.EmaNavigationState
import es.babel.ema.presentation.base.BaseViewModel

class EmaUserViewModel : BaseViewModel<EmaUserState, EmaNavigationState>() {

    override fun onStartFirstTime(statePreloaded: Boolean) {

    }


    override fun createInitialViewState(): EmaUserState {
       return EmaUserState()
    }
}
